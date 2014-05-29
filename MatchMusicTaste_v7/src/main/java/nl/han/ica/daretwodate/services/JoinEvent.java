package nl.han.ica.daretwodate.services;

import org.apache.http.client.*;
import org.apache.http.*;
import org.apache.http.impl.client.*;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;

import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.util.Scanner;

public class JoinEvent implements IJoinEvent {
    public boolean joinEvent(String lastfmApiKey, String lastfmSessionKey,
                             String eventId, String status, String secretLastfm) {
        try
        {
            String apiSignature = constructSignature(lastfmApiKey, eventId, lastfmSessionKey,
                    status, secretLastfm);
            System.out.println("api sig: " + apiSignature);

            String uri = "http://ws.audioscrobbler.com/2.0/";
            String urlParameters = "method=event.attend&event=" + eventId +
            "&status=" + status + "&api_key=" + lastfmApiKey + "&api_sig=" + apiSignature +
                    "&sk=" + lastfmSessionKey;

            URL url = new URL(uri);
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", "Mozilla/4.5");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("charset", "utf-8");
            connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
            connection.setUseCaches(false);

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            Scanner s = null;
            if (connection.getResponseCode() != 200) {
                s = new Scanner(connection.getErrorStream());
            } else {
                InputStream is = connection.getInputStream();
                s = new Scanner(is);
            }
            s.useDelimiter("\\Z");
            String response = s.next();
            System.out.println("\nResponse: " + response + "\n\n");

            //InputStream xml = connection.getInputStream();
//
//            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//            DocumentBuilder db = dbf.newDocumentBuilder();
//            Document doc = db.parse(xml);
//
//            NodeList country = doc.getElementsByTagName("status");
//            Element line = (Element) country.item(0);

            //result = getCharacterDataFromElement(line);
//            // Construct the parameter list
//            List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
//            urlParameters.add(new BasicNameValuePair("method", "event.attend"));
//            urlParameters.add(new BasicNameValuePair("event", eventId));
//            urlParameters.add(new BasicNameValuePair("status", status));
//            urlParameters.add(new BasicNameValuePair("api_key", lastfmApiKey));
//            urlParameters.add(new BasicNameValuePair("api_sig", apiSignature));
//            urlParameters.add(new BasicNameValuePair("sk", lastfmSessionKey));
//
//            // Construct and set the https POST message
//            HttpClient client =  HttpClientBuilder.create().build();
//            HttpPost post = new HttpPost("http://ws.audioscrobbler.com/2.0/");
//            post.setEntity(new UrlEncodedFormEntity(urlParameters));
//
//            HttpResponse response = client.execute(post);
////            String result = new BasicResponseHandler().handleResponse(response);
////            System.out.println(result);
////
//            //System.out.println(result);
//            if (response.getStatusLine().getStatusCode() != 200) {
//                System.out.println("LoginOnLastfm: error code is: " +
//                        response.getStatusLine().getStatusCode());
//                return false;
//            }

//            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//            DocumentBuilder db = dbf.newDocumentBuilder();
//            InputSource is = new InputSource();
//            is.setCharacterStream(new StringReader(result));
//
//            // Retrieve the session key
//            Document doc = db.parse(is);
//            NodeList keyList = doc.getElementsByTagName("key");
//            Element line = (Element) keyList.item(0);
//            sessionKey = getCharacterDataFromElement(line);
        }
        catch(Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
        }

        return true;
    }

    private static String getCharacterDataFromElement(Element e)
    {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData)
        {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "?";
    }

    private String constructSignature(String apiKeyLastfm, String eventId, String lastfmSessionKey,
                                      String status, String secret) {
        // construct the signature
        String sig = "api_key" + apiKeyLastfm + "event" + eventId + "methodevent.attendsk" +
                lastfmSessionKey + "status" + status + secret;
        System.out.println("api sig unhashed: " + sig);
        StringBuffer hex = new StringBuffer();
        // Apply md5 hashing to the signature
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(sig.getBytes("UTF-8"));
            byte[] digest = md5.digest();
            for(int i = 0; i < digest.length; i++) {
                hex.append(Integer.toHexString(0xFF & digest[i]));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return hex.toString();
    }
}

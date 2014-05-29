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
import java.util.List;
import java.util.ArrayList;
import java.security.MessageDigest;

public class LoginOnLastfm implements ILoginOnLastfm {

    private String sessionKey;

    public boolean login(String userName, String password, String apiKeyLastfm, String secretLastfm) {
        sessionKey = "";

        try
        {
            // Get the api signature
            //constructSignature(userName, password, apiKeyLastfm, secret);

            String apiSignature = constructSignature(userName, password, apiKeyLastfm, secretLastfm);

            // Construct the parameter list
            List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
            urlParameters.add(new BasicNameValuePair("method", "auth.getMobileSession"));
            urlParameters.add(new BasicNameValuePair("username", userName));
            urlParameters.add(new BasicNameValuePair("password", password));
            urlParameters.add(new BasicNameValuePair("api_key", apiKeyLastfm));
            urlParameters.add(new BasicNameValuePair("api_sig", apiSignature));

            // Construct and set the https POST message
            HttpClient client =  HttpClientBuilder.create().build();
            HttpPost post = new HttpPost("https://ws.audioscrobbler.com/2.0/");
            post.setEntity(new UrlEncodedFormEntity(urlParameters));

            HttpResponse response = client.execute(post);
            String result = new BasicResponseHandler().handleResponse(response);

            if (response.getStatusLine().getStatusCode() != 200) {
                System.out.println("LoginOnLastfm: error code is: " +
                        response.getStatusLine().getStatusCode());
                return false;
            }

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(result));

            // Retrieve the session key
            Document doc = db.parse(is);
            NodeList keyList = doc.getElementsByTagName("key");
            Element line = (Element) keyList.item(0);
            sessionKey = getCharacterDataFromElement(line);
        }
        catch(Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
        }

        return true;
    }

    public String getSessionKey() {
        return sessionKey;
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

    private String constructSignature(String userName, String password, String apiKeyLastfm, String secretLastfm) {
        // construct the signature
        String sig = "api_key" + apiKeyLastfm + "methodauth.getMobileSessionpassword" + password +
                "username" + userName + secretLastfm;
        System.out.println("api key unhashed " + sig);
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

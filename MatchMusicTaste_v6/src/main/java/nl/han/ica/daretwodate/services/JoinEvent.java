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

public class JoinEvent implements IJoinEvent {
    public boolean joinEvent(String lastfmApiKey, String lastfmApiSig, String lastfmSessionKey, long eventId, int status) {

        try
        {
            // Construct the parameter list
            List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
            urlParameters.add(new BasicNameValuePair("method", "event.attend"));
            urlParameters.add(new BasicNameValuePair("event", Long.toString(eventId)));
            urlParameters.add(new BasicNameValuePair("status", Integer.toString(status)));
            urlParameters.add(new BasicNameValuePair("api_key", lastfmApiKey));
            urlParameters.add(new BasicNameValuePair("api_sig", lastfmApiSig));
            urlParameters.add(new BasicNameValuePair("sk", lastfmSessionKey));

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
}

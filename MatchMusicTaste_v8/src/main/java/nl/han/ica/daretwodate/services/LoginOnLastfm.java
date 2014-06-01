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
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ArrayList;
import java.security.MessageDigest;
import nl.han.ica.daretwodate.services.MD5Hashing;
import nl.han.ica.daretwodate.services.GetCharacterDataFromElement;

public class LoginOnLastfm implements ILoginOnLastfm {

    private String sessionKey;

    public boolean login(String userName, String password, String apiKeyLastfm, String secretLastfm) {
        sessionKey = "";

        try
        {
            // construct and get the api signature
            MD5Hashing md5 = new MD5Hashing();
            String apiSignatureUnhashed = "api_key" + apiKeyLastfm + "methodauth.getMobileSessionpassword" + password +
                    "username" + userName + secretLastfm;
            String apiSignature = md5.md5(apiSignatureUnhashed);

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
            GetCharacterDataFromElement gcd = new GetCharacterDataFromElement();
            sessionKey = gcd.getCharacterDataFromElement(line);
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
}

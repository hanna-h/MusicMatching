package nl.han.ica.daretwodate.services;

import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Scanner;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import nl.han.ica.daretwodate.services.MD5Hashing;

public class JoinEvent implements IJoinEvent {
    public boolean joinEvent(String lastfmApiKey, String lastfmSessionKey,
                             String eventId, String status, String secretLastfm) {
        try
        {
            // construct the signature
            MD5Hashing md5 = new MD5Hashing();
            String apiSignatureUnhashed = "api_key" + lastfmApiKey + "event" + eventId + "methodevent.attendsk" +
                    lastfmSessionKey + "status" + status + secretLastfm;
            String apiSignature = md5.md5(apiSignatureUnhashed);

            // construct the url
            String uri = "http://ws.audioscrobbler.com/2.0/";
            String urlParameters = "method=event.attend&event=" + eventId +
            "&status=" + status + "&api_key=" + lastfmApiKey + "&api_sig=" + apiSignature +
                    "&sk=" + lastfmSessionKey;
            URL url = new URL(uri);
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            // send the message
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            Scanner s = null;
            if (connection.getResponseCode() != 200) {
                s = new Scanner(connection.getErrorStream());
                String response = s.next();
                System.out.println("\nError in JoinEvent. Response: " + response + "\n\n");
                return false;
            } else {
                InputStream is = connection.getInputStream();
                s = new Scanner(is);
            }
            s.useDelimiter("\\Z");
            String response = s.next();

            InputStream xml = connection.getInputStream();

            // parse the message
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(response));
            Document doc = db.parse(is);
            NodeList statusList = doc.getElementsByTagName("lfm");
            Element line = (Element) statusList.item(0);
            String statusResult = line.getAttributes().getNamedItem("status").getNodeValue();
        }
        catch(Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
        }

        return true;
    }
}

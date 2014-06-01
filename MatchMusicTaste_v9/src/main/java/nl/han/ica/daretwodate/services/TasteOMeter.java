package nl.han.ica.daretwodate.services;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;
import java.util.HashMap;
import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import nl.han.ica.daretwodate.services.GetCharacterDataFromElement;


public class TasteOMeter implements ITasteOMeter
{
    private String apiKeyLastfm;
    private float score;
    private List<String> commonArtists = new ArrayList<String>();

    public boolean callTasteOMeter(String user1, String user2, String limit, String lastfmApiKey)
    {
        // reset the values
        score = 0;
        commonArtists.clear();

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        try
        {
            config.setServerURL(new URL("http://ws.audioscrobbler.com/2.0/"));
            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);

            // Construct the message to send to the last.fm api
            HashMap<String, String> params = new HashMap<String, String>();
            params.put("type1", "user");
            params.put("type2", "user");
            params.put("value1", user1);
            params.put("value2", user2);
            params.put("limit", limit);
            params.put("api_key", lastfmApiKey);

            Object[] param = new Object[]{params};

            String resultsUnparsed = (String) client.execute("tasteometer.compare", param);

            // last.fm returns bad xml so we have to remove some unwanted characters
            String result = resultsUnparsed.replace("\\n", "").replace("\\\"", "\"");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(result));

            // Retrieve the compatibility score
            Document doc = db.parse(is);
            NodeList scoreList = doc.getElementsByTagName("score");
            Element line = (Element) scoreList.item(0);
            GetCharacterDataFromElement gcd = new GetCharacterDataFromElement();
            score = Float.parseFloat(gcd.getCharacterDataFromElement(line));
            //System.out.println(score);
            if (score == 0) { // xml is not valid
                return false;
            }

            // Retrieve the list of artists
            NodeList artist = doc.getElementsByTagName("artist");
            for (int i = 0; i < artist.getLength(); i++) {
                Element element = (Element) artist.item(i);
                NodeList nameList = element.getElementsByTagName("name");
                line = (Element) nameList.item(0);
                String name = gcd.getCharacterDataFromElement(line);
                commonArtists.add(name);
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
        }

        return true;
    }

    public float getTasteOMeterPercentage() {
        return score;
    }

    public List<String> getTasteOMeterArtists() {
        return commonArtists;
    }
}


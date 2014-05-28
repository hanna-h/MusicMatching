package nl.han.ica.daretwodate.services;

        import org.apache.xmlrpc.client.XmlRpcClient;
        import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

        import java.net.URL;
        import java.util.HashMap;
        import javax.xml.parsers.*;
        import org.xml.sax.InputSource;
        import org.w3c.dom.*;
        import java.io.*;


public class TasteOMeter implements ITasteOMeter
{

    public void callTasteOMeter(String user1, String user2, String limit)
    {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        try
        {
            config.setServerURL(new URL("http://ws.audioscrobbler.com/2.0/"));
            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);


            HashMap<String, String> params = new HashMap<String, String>();
            params.put("type1", "user");
            params.put("type2", "user");
            params.put("value1", user1);
            params.put("value2", user2);
            params.put("limit", limit);
            params.put("api_key", "8b1b06b8ae1495d3beda8d789ac3b720");

            Object[] param = new Object[]{params};

            //HashMap result = (HashMap) client.execute("tasteometer.compare", param);


            String results = (String) client.execute("tasteometer.compare", param);

            // String result = (String) result.get("score");
            String result = results.replace("\\n", "").replace("\\\"", "\"");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(result));

            Document doc = db.parse(is);
            NodeList score = doc.getElementsByTagName("score");
            Element line = (Element) score.item(0);
            System.out.println("score: " + getCharacterDataFromElement(line));

            /*
            // iterate more items
            NodeList artist = doc.getElementsByTagName("artist");

            for (int i = 0; i < artist.getLength(); i++) {
            Element element = (Element) artist.item(i);

            NodeList name = element.getElementsByTagName("name");
            Element line = (Element) name.item(0);
            System.out.println("Name: " + getCharacterDataFromElement(line));
            }
             */


                //System.out.println(result);


        }
            catch(Exception e)
            {
                System.out.println("Exception: " + e.getMessage());
            }

    }

    public static String getCharacterDataFromElement(Element e)
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


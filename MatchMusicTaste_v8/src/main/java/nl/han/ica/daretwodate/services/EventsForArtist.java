package nl.han.ica.daretwodate.services;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.w3c.dom.CharacterData;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by root on 26-5-14.
 */
public class EventsForArtist implements IEventsForArtist {

    public List<HashMap> getEventsForArtist(String location, List<String> artists, String apiKey)
    {
        List<HashMap> eventList = new ArrayList<HashMap>();
        HashMap<String, String> events = new HashMap<String, String>();

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        //System.out.println(artists.size());
        for(int j = 0; j < artists.size(); j++) {

            try {

                config.setServerURL(new URL("http://ws.audioscrobbler.com/2.0/"));
                XmlRpcClient client = new XmlRpcClient();
                client.setConfig(config);

                HashMap<String, String> params = new HashMap<String, String>();
                params.put("artist", artists.get(j));
                params.put("api_key", apiKey);

                Object[] param = new Object[]{params};

                String resultsUnparsed = (String) client.execute("artist.getevents", param);

                // last.fm returns bad xml so we have to remove some unwanted characters
                String result = resultsUnparsed.replace("\\n", "").replace("\\\"", "\"");

                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                InputSource is = new InputSource();
                is.setCharacterStream(new StringReader(result));

                Document doc = db.parse(is);
                // Retrieve the list of artists
                NodeList event = doc.getElementsByTagName("event");
                for (int i = 0; i < event.getLength(); i++) {
                    Element element = (Element) event.item(i);
                    NodeList id = element.getElementsByTagName("id");
                    Element elementId = (Element) id.item(0);
                     //System.out.println(getStringType(elementId));
                    NodeList title = element.getElementsByTagName("title");
                    Element elementTitle = (Element) title.item(0);
                     //System.out.println(getStringType(elementTitle));
                    NodeList date = element.getElementsByTagName("startDate");
                    Element elementDate = (Element) date.item(0);
                     //System.out.println(getStringType(elementDate));
                    NodeList venue = element.getElementsByTagName("venue");
                    Element element1 = (Element) venue.item(0);
                    NodeList venueName = element1.getElementsByTagName("name");
                    Element elementName = (Element) venueName.item(0);
                     //System.out.println(getStringType(elementName));
                    NodeList locationEvent = element1.getElementsByTagName("location");
                    Element element2 = (Element) locationEvent.item(0);
                    NodeList city = element2.getElementsByTagName("city");
                    Element elementCity = (Element) city.item(0);
                     //System.out.println(getStringType(elementCity));
                    NodeList country = element2.getElementsByTagName("country");
                    Element element3 = (Element) country.item(0);
                     //System.out.println(getStringType(element3));
                     //System.out.println("____________________________________");
                    if (getStringType(element3).equals(location)) {
                        //System.out.println("yes");
                        events.put("id", getStringType(elementId));
                        events.put("artist", artists.get(j));
                        events.put("title", getStringType(elementTitle));
                        events.put("venue", getStringType(elementName));
                        events.put("city", getStringType(elementCity));
                        events.put("date", getStringType(elementDate));
                        eventList.add(events);
                        //events.clear();
                    }
                }


            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }

        return eventList;
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

    String getStringType(Element name)
    {
        String tag = getCharacterDataFromElement(name);
        return tag;
    }
}

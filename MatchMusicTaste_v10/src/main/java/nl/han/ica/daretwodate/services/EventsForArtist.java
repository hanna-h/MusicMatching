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
        //For every artist output from the tasteOmeter.
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
                // Retrieve the list of events
                // go through the xml layer structure.
                /*<events artist="Cher" xmlns:geo="http://www.w3.org/2003/01/geo/wgs84_pos#" total="4">
                   <event>
                    <id></id>
                    <title></title>
                    <artists>
                      <artist></artist>
                      <headliner></headliner>
                    </artists>
                    <venue>
                      <name></name>
                      <location>
                        <city></city>
                        <country></country>
                        <street></street>
                        <postalcode></postalcode>
                        <geo:point>
                          <geo:lat></geo:lat>
                          <geo:long></geo:long>
                        </geo:point>
                        <timezone></timezone>
                      </location>
                      <url></url>
                    </venue>
                    <startDate></startDate>
                     ...
                  </event>
                  ...
                </events>
                * */
                NodeList event = doc.getElementsByTagName("event");
                for (int i = 0; i < event.getLength(); i++) {
                    Element elementEvent = (Element) event.item(i);
                    NodeList id = elementEvent.getElementsByTagName("id");
                    Element elementId = (Element) id.item(0);
                    NodeList title = elementEvent.getElementsByTagName("title");
                    Element elementTitle = (Element) title.item(0);
                    NodeList date = elementEvent.getElementsByTagName("startDate");
                    Element elementDate = (Element) date.item(0);
                    NodeList venue = elementEvent.getElementsByTagName("venue");
                    Element elementVenue = (Element) venue.item(0);
                    NodeList venueName = elementVenue.getElementsByTagName("name");
                    Element elementName = (Element) venueName.item(0);
                    NodeList locationEvent = elementVenue.getElementsByTagName("location");
                    Element elementLocation = (Element) locationEvent.item(0);
                    NodeList city = elementLocation.getElementsByTagName("city");
                    Element elementCity = (Element) city.item(0);
                    NodeList country = elementLocation.getElementsByTagName("country");
                    Element elementCountry = (Element) country.item(0);
                    if (getStringType(elementCountry).equals(location)) {
                        events.put("id", getStringType(elementId));
                        events.put("artist", artists.get(j));
                        events.put("title", getStringType(elementTitle));
                        events.put("venue", getStringType(elementName));
                        events.put("city", getStringType(elementCity));
                        events.put("date", getStringType(elementDate));
                        eventList.add(events);
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

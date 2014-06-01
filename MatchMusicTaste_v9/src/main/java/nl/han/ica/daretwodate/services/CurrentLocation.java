package nl.han.ica.daretwodate.services;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import nl.han.ica.daretwodate.services.GetCharacterDataFromElement;

public class CurrentLocation implements ICurrentLocation {
    public String getCountry(String ipaddress)
    {
        String result = new String();

         try {

                String uri = "http://freegeoip.net/xml/" + ipaddress;

                URL url = new URL(uri);
                HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Accept", "application/xml");

                InputStream xml = connection.getInputStream();

                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(xml);

                NodeList country = doc.getElementsByTagName("CountryName");
                Element line = (Element) country.item(0);

                GetCharacterDataFromElement gcd = new GetCharacterDataFromElement();
                result = gcd.getCharacterDataFromElement(line);

         }
            catch(Exception e)
            {
                System.out.println("Exception: " + e.getMessage());
            }

        return result;
    }
}

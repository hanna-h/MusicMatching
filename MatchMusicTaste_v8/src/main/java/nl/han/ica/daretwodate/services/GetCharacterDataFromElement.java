package nl.han.ica.daretwodate.services;

import org.w3c.dom.*;

public class GetCharacterDataFromElement {
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

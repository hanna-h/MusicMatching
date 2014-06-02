package nl.han.ica.daretwodate.services;

import java.util.List;
/**
 * Created by root on 27-5-14.
 */
public interface ITasteOMeter {
    boolean callTasteOMeter(String user1, String user2, String limit, String lastfmApiKey);
    int getTasteOMeterPercentage();
    List<String> getTasteOMeterArtists();
}

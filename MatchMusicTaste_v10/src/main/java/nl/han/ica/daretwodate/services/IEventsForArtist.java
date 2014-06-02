package nl.han.ica.daretwodate.services;

import java.util.HashMap;
import java.util.List;

/**
 * Created by root on 29-5-14.
 */
public interface IEventsForArtist {
    public List<HashMap> getEventsForArtist(String location, List<String> artists, String apiKey);

}

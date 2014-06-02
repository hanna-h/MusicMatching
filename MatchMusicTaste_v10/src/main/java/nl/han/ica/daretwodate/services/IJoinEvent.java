package nl.han.ica.daretwodate.services;

public interface IJoinEvent {
    boolean joinEvent(String lastfmApiKey, String lastfmSessionKey, String eventId, String status, String secretLastfm);
}

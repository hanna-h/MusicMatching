package nl.han.ica.daretwodate.services;

public interface IJoinEvent {
    boolean joinEvent(String lastfmApiKey, String lastfmApiSig, String lastfmSessionKey, long eventId, int status);
}

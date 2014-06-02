package nl.han.ica.daretwodate.domain;

import nl.han.ica.daretwodate.*;
import nl.han.ica.daretwodate.dao.iMatchMusicTasteDao;
import nl.han.ica.daretwodate.dao.MatchMusicTasteDao;
import nl.han.ica.daretwodate.model.Users;
import nl.han.ica.daretwodate.services.*;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Endpoint
public class MatchMusicTasteEndpoint {
    private final iMatchMusicTasteDao matchMusicTasteDao;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    private ICurrentLocation currentLocation;
    private IEventsForArtist eventsForArtist;
    private JoinEvent joinEvent;
    private LoginOnLastfm loginOnLastfm;
    private ITasteOMeter tasteOMeter;

    public MatchMusicTasteEndpoint(Marshaller marshaller, Unmarshaller unmarshaller, CurrentLocation currentLocation,
                                   EventsForArtist eventsForArtist, JoinEvent joinEvent, LoginOnLastfm loginOnLastfm,
                                   ITasteOMeter tasteOMeter, iMatchMusicTasteDao matchMusicTasteDao) {
        this.marshaller = marshaller;
        this.unmarshaller = unmarshaller;
        this.currentLocation = currentLocation;
        this.eventsForArtist = eventsForArtist;
        this.joinEvent = joinEvent;
        this.loginOnLastfm = loginOnLastfm;
        this.tasteOMeter = tasteOMeter;
        this.matchMusicTasteDao = matchMusicTasteDao;

        matchMusicTasteDao.getUsers();
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @PayloadRoot(localPart = "MatchMusicTasteRequest", namespace = "http://www.han.nl/schemas/messages")
    public MatchMusicTasteResponse doMusicMatching(MatchMusicTasteRequest req) {
        String lastfmApiKey = req.getInput().getLastfmApiKey();
        String lastfmSecret = req.getInput().getLastfmSecret();
        String ipAddress = req.getInput().getIpaddress();
        String user1 = req.getInput().getUsername1();
        String user2 = req.getInput().getUsername2();

        MatchMusicTasteResult result = new MatchMusicTasteResult();


        System.out.println("Get user from database test: " + matchMusicTasteDao.getUser("fairyglen").getLastfmUsername());

        if (loginOnLastfm.login(user1, "rainbow", lastfmApiKey, lastfmSecret) ) {
            System.out.println("Login succeeded");
            String lastfmSessionKey = loginOnLastfm.getSessionKey();
            System.out.println("Login session key: " + lastfmSessionKey);

            if ( tasteOMeter.callTasteOMeter(user1, user2, "10", lastfmApiKey) ) {
                System.out.println("A match was found");
                System.out.println("Taste-o-Meter score: " + tasteOMeter.getTasteOMeterPercentage());
                List<String> commonArtists = tasteOMeter.getTasteOMeterArtists();
                for (int i = 0; i < commonArtists.size(); i++) {
                    System.out.println(commonArtists.get(i));
                }

                result.setPercentage(tasteOMeter.getTasteOMeterPercentage());


                List <HashMap> events = eventsForArtist.getEventsForArtist("Netherlands", commonArtists , lastfmApiKey);

                HashMap <String, String> temp = (HashMap) events.get(0);
                Event event = new Event();
                event.setArtist(temp.get("artist"));
                event.setCity(temp.get("city"));
                event.setTitle(temp.get("title"));
                event.setTime(temp.get("date"));
                event.setVenue(temp.get("venue"));
                //event.setCity("arnhem");
                result.setEvents(event);


                if (joinEvent.joinEvent(lastfmApiKey, lastfmSessionKey, "3849720", "2", lastfmSecret) ) {
                    System.out.println("Joined event succesfully");
                }
            }

        }

        MatchMusicTasteResponse resp = new MatchMusicTasteResponse();
        resp.setResult(result);

        return resp;
    }

}

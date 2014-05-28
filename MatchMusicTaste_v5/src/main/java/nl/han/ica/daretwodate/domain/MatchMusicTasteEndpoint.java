package nl.han.ica.daretwodate.domain;

import nl.han.ica.daretwodate.*;
import nl.han.ica.daretwodate.dao.iMatchMusicTasteDao;
import nl.han.ica.daretwodate.dao.MatchMusicTasteDao;
import nl.han.ica.daretwodate.model.Users;
import nl.han.ica.daretwodate.services.CurrentLocation;
import nl.han.ica.daretwodate.services.EventsForArtist;
import nl.han.ica.daretwodate.services.JoinEvent;
import nl.han.ica.daretwodate.services.LoginOnLastfm;
import nl.han.ica.daretwodate.services.ITasteOMeter;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import java.util.List;

@Endpoint
public class MatchMusicTasteEndpoint {
    private final iMatchMusicTasteDao matchMusicTasteDao;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    private CurrentLocation currentLocation;
    private EventsForArtist eventsForArtist;
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
        System.out.println(matchMusicTasteDao.getUser("fairyglen").getLastfmUsername());

        String lastfmApiKey = req.getInput().getLastfmApiKey();

        MatchMusicTasteResult result = new MatchMusicTasteResult();
        result.setPercentage(56);
        MatchMusicTasteResponse resp = new MatchMusicTasteResponse();
        resp.setResult(result);

        tasteOMeter.callTasteOMeter("Jansuun","fairyglen","3");


        return resp;
    }

}

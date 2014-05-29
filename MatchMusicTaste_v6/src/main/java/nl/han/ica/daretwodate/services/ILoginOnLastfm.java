package nl.han.ica.daretwodate.services;

/**
 * Created by root on 28-5-14.
 */
public interface ILoginOnLastfm {
    boolean login(String userName, String password, String apiKeyLastfm, String secret);
    String getSessionKey();
}

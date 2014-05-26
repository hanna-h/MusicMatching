package nl.han.ica.daretwodate.dao;

import nl.han.ica.daretwodate.model.Users;

public interface iMatchMusicTasteDao {
    void save(Users user);
    void getUsers();
    Users getUser(String username);
}

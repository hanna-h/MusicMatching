package nl.han.ica.daretwodate.dao;

import nl.han.ica.daretwodate.model.Users;

import javax.persistence.*;
import java.util.List;

public class MatchMusicTasteDao implements iMatchMusicTasteDao {
    private List<Users> results;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
    private EntityManager em = emf.createEntityManager();

    public void save(Users user) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(user);
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void getUsers() {
        em.getTransaction().begin();
        results = em.createQuery( "select u from Users u").getResultList();
    }

    public Users getUser(String username) {
        return em.find(Users.class, username);
    }
}

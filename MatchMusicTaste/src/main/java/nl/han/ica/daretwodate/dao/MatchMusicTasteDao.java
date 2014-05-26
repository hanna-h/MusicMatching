package nl.han.ica.daretwodate.dao;

import nl.han.ica.daretwodate.model.MatchMusicTaste;

import javax.persistence.*;

public class MatchMusicTasteDao implements iMatchMusicTasteDao {
    public void save(MatchMusicTaste matcher) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculator");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        try {
            tx.begin();
            em.persist(matcher);
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

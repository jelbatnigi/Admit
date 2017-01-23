package com.admitone.dao;

import com.admitone.model.Shows;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by j_elbatn on 1/22/17.
 */

@Repository
public class ShowDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Shows> getShowsByIdRange(long fromShowId, long toShowId)
    {
        List<Shows> shows = entityManager.createQuery(
                "from Shows where showId between :fromShowId AND :toShowId")
                .setParameter("fromShowId", fromShowId).
                        setParameter("toShowId", toShowId)
                .getResultList();
        return shows;
    }
}

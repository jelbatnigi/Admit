package com.admitone.dao;

import com.admitone.model.UserInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by j_elbatn on 1/22/17.
 */
@Repository
public class UserInfoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public UserInfo finsUserByEmail(String userName)
    {
        UserInfo userInfo = (UserInfo) entityManager.createQuery(
                "from UserInfo where email = :email")
                .setParameter("email", userName)
                .getSingleResult();
        return userInfo;
    }

}

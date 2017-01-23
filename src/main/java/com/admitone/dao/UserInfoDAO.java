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

    public UserInfo finsUserByEmail(String userName) throws Exception {
        UserInfo userInfo = null;

        try{
            userInfo = (UserInfo) entityManager.createQuery(
                    "from UserInfo where email = :email")
                    .setParameter("email", userName)
                    .getSingleResult();
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception("Unable to get User email");
        }
        return userInfo;
    }

    public UserInfo getUserInfoById(long userId) throws Exception {
        UserInfo userInfo = null;

        try{
            userInfo = (UserInfo) entityManager.createQuery(
                    "from UserInfo where userId = :userId")
                    .setParameter("userId", userId)
                    .getSingleResult();
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception("Unable to get User Id");
        }
        return userInfo;
    }

}

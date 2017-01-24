package com.admitone.services;

import com.admitone.dao.UserInfoDAO;
import com.admitone.model.UserInfo;
import com.admitone.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by j_elbatn on 1/23/17.\
 */
public class UserInfoService implements UserDetailsService {

    @Autowired
    UserInfoDAO userInfoDAO;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userInfoDAO.findUserByEmail(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(userInfo == null)
        {
            throw new UsernameNotFoundException("User Not Found");
        }
        return new UserDetailsImpl(userInfo);

    }

    public UserInfo getUserById(long userId) throws Exception
    {
        UserInfo userInfo;
        try {
            userInfo = userInfoDAO.getUserInfoById(userId);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return userInfo;

    }

}

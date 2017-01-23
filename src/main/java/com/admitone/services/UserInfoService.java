package com.admitone.services;

import com.admitone.dao.UserInfoDAO;
import com.admitone.model.UserInfo;
import com.admitone.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by j_elbatn on 1/22/17.
 */
@Service
public class UserInfoService implements UserDetailsService{

    @Autowired
    UserInfoDAO userInfoDAO;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoDAO.finsUserByEmail(userName);

        if(userInfo == null)
        {
            throw new UsernameNotFoundException("User Not Found");
        }
        return new UserDetailsImpl(userInfo);

    }
}

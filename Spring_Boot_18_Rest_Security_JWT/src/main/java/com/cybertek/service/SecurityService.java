package com.cybertek.service;

import com.cybertek.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService implements UserDetailsService {

    private final UserService userService;

    public SecurityService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User foundUser = loadUser(s);
        if(foundUser == null){
            throw new UsernameNotFoundException("user not found! " + s);
        }
        // because there is no need for userdetail class, we are directly giving username and password to spring to create userdetail object...
        return new org.springframework.security.core.userdetails.User(foundUser.getUserName(), foundUser.getPassword(), listAuthorities(foundUser));
    }

    public User loadUser(String value){
        boolean isEmail = value.contains("@");
        return isEmail ? userService.readByEmail(value) : userService.readByUsername(value);
    }

    // because there is no userdetail class we are defining authorities here in service...
    private List<GrantedAuthority> listAuthorities(User user){
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority(user.getRole().name()));
        return grantedAuthorityList;
    }
}

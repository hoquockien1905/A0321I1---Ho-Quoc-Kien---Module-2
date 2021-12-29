package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username" + username + " not found!");
        }

        List<String> roles = userRoleRepository.findAllRoleByUser(user.getUserId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (roles != null) {
            for (String roleName : roles){
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roleName);
                grantedAuthorities.add(grantedAuthority);
            }
        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);

        return userDetails;
    }
}

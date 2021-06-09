package com.signette.service;

import com.signette.domains.UserEntity;
import com.signette.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserMail(mail)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + mail));

        return UserDetailsImpl.build(user);
    }
}

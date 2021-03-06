package com.signette.service;

import com.signette.domains.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    private long id;
    private String mail;
    private String password;
    private GrantedAuthority authorities;

    public UserDetailsImpl(long id, String mail, String password, GrantedAuthority authorities) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user) {
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getRoleType().name());
        return new UserDetailsImpl(
                user.getUserId(),
                user.getUserMail(),
                user.getUserPassword(),
                authority
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authority = new ArrayList<>();
        authority.add(authorities);
        return authority;
    }

    public long getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

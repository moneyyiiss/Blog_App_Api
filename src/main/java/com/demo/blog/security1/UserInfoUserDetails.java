package com.demo.blog.security1;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserInfoUserDetails implements UserDetails {


    private String name;
    private String password;
    List<GrantedAuthority> authorities;

    public UserInfoUserDetails(UserInfo userInfo){
        name = userInfo.getName();
        password = userInfo.getPassword();
        //not cool method - old method to do this.
        String roles = userInfo.getRoles();
        String[] rolesArray = roles.split(",");
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(String role: rolesArray){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
            authorities.add(grantedAuthority);
        }

    }





    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}

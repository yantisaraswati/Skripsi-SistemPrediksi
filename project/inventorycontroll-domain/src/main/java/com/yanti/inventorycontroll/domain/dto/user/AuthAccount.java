package com.yanti.inventorycontroll.domain.dto.user;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class AuthAccount {
    private Long userId;

    private Long organizationId;

    private String name;

    private String username;
    
    private String password;
    
    private List<? extends GrantedAuthority> authorities;
    
    private Boolean accountNonExpired;
    
    private Boolean accountNonLocked;
    
    private Boolean credentialsNonExpired;
}
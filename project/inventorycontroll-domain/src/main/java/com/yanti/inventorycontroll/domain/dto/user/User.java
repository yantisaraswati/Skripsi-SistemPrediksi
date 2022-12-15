package com.yanti.inventorycontroll.domain.dto.user;

import java.util.List;

import lombok.Data;

@Data
public class User {
    private Long userId;

    private Long organizationId;

    private String name;

    private String username;

    private List<String> authorities;
}
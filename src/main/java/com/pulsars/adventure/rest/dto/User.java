package com.pulsars.adventure.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private String userName;
    private String password;
    private String role;
}

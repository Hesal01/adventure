package com.pulsars.adventure.service;


import com.pulsars.adventure.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean hasAccess(String userName){
        String securityContextUserName = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return securityContextUserName.equals(userName);
    }

}

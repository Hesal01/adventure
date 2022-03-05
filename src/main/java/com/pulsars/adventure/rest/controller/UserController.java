package com.pulsars.adventure.rest.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pulsars.adventure.rest.dto.User;
import com.pulsars.adventure.rest.mapper.UserMapper;
import com.pulsars.adventure.service.Exception.UniqueUsernameException;
import com.pulsars.adventure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PreAuthorize("@authenticationService.hasAccess(#userName)")
    @GetMapping("/user/{userName}")
    public ResponseEntity<User> getUser(@PathVariable String userName){
        return ResponseEntity.ok().body(userMapper.map(userService.getUser(userName)));
    }

    @GetMapping("/users")
    public Iterable<User> getUsers(){
        return userMapper.mapTo(userService.getUsers());
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) throws UniqueUsernameException {
        return ResponseEntity.ok().body(userMapper.map(userService.saveUser(userMapper.map(user))));
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            try {
                String refreshToken = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(refreshToken);
                String userName = decodedJWT.getSubject();
                com.pulsars.adventure.model.User user = (com.pulsars.adventure.model.User) userService.loadUserByUsername(userName);
                String accessToken = JWT.create()
                        .withSubject(user.getUserName())
                        .withExpiresAt(new Date(System.currentTimeMillis()+10*60*1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRole())
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("accessToken", accessToken);
                tokens.put("refreshToken", refreshToken);
                response.setContentType(APPLICATION_JSON_VALUE );
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            }
            catch (Exception exception){
                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                //response.sendError(FORBIDDEN.value());
                Map<String, String> tokens = new HashMap<>();
                tokens.put("accessToken", exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            }

        }
        else{
            throw new RuntimeException("Refresh token is missing");
        }
    }

}

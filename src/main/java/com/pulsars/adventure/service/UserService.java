package com.pulsars.adventure.service;

import com.pulsars.adventure.model.User;
import com.pulsars.adventure.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        log.info("Saving new user {} to database", user.getUserName());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.getUserByUserName(userName);
        if(user == null){
            throw new UsernameNotFoundException("User name not found in database.");
        }
        return org.springframework.security.core.userdetails.User.builder()
                .passwordEncoder(input -> bCryptPasswordEncoder.encode(input))
                .username(user.getUserName())
                .password(user.getPassword())
                .authorities(user.getRole())
                .build();
    }

}

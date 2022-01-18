package com.pulsars.adventure.repository;

import com.pulsars.adventure.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public User getUserByUserName(String userName);

}

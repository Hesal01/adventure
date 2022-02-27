package com.pulsars.adventure.service.Exception;

public class UniqueUsernameException extends Exception {

    public UniqueUsernameException(String message) {
        super("Username is not unique: " + message);
    }

}

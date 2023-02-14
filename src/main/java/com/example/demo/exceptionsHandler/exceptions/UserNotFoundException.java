package com.example.demo.exceptionsHandler.exceptions;

import java.util.NoSuchElementException;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(long id) {
        super("L'utilisateur "+id+"n'existe pas");
    }
}

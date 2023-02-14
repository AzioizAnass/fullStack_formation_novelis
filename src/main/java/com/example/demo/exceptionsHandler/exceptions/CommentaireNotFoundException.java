package com.example.demo.exceptionsHandler.exceptions;

import java.util.NoSuchElementException;

public class CommentaireNotFoundException extends Exception {
    public CommentaireNotFoundException(long id) {
        super("Le commentaire "+id+"n'existe pas");
    }
}

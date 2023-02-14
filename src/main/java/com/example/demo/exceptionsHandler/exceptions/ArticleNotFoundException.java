package com.example.demo.exceptionsHandler.exceptions;

import java.util.NoSuchElementException;

public class ArticleNotFoundException extends Exception {
    public ArticleNotFoundException(long id) {
        super("l'article "+id+"n'existe pas");
    }
}

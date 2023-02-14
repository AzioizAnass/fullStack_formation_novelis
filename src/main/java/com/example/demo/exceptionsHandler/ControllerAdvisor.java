package com.example.demo.exceptionsHandler;

import com.example.demo.exceptionsHandler.exceptions.ArticleNotFoundException;
import com.example.demo.exceptionsHandler.exceptions.CommentaireNotFoundException;
import com.example.demo.exceptionsHandler.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(
            UserNotFoundException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "User not found !");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CommentaireNotFoundException.class)
    public ResponseEntity<Object> handleCommentaireNotFoundException(
            CommentaireNotFoundException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Comment not found !");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ArticleNotFoundException.class)
    public ResponseEntity<Object> handleArticleNotFoundException(
            ArticleNotFoundException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Article not found !");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}

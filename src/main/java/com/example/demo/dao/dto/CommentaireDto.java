
package com.example.demo.dao.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CommentaireDto {
    private long commentId ;
    private String commentContent;
    private String commentDate;
    private ArticleDto article;
    private UtilisateurDto utilisateur;
}

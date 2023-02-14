package com.example.demo.dao.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ArticleDto {
    private long articleId;
    private String articleContent;
    private String articleDate;
    private String titre;
    private Set<CommentaireDto> commentaires ;

}

package com.example.demo.dao.mapper;
import com.example.demo.dao.domain.Article;
import com.example.demo.dao.dto.ArticleDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring",uses={CommentaireMapper.class})
public interface ArticleMapper {
    ArticleDto articleToArticleDTO (Article artcl);
    Article  articleDTOToArticle (ArticleDto artcl);
    Article upDateArticleFromDto(ArticleDto articleDto , @MappingTarget Article artcl);
    List<ArticleDto> mapToArticles(List<Article> articleEntityList);
}


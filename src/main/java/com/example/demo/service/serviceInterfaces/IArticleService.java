package com.example.demo.service.serviceInterfaces;
import com.example.demo.dao.dto.ArticleDto;
import com.example.demo.exceptionsHandler.exceptions.ArticleNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IArticleService {
    ArticleDto saveArticle(ArticleDto art);

    ArticleDto updateArticle(ArticleDto art, Long id);

    String deleteArticle(Long id);

    List<ArticleDto> findAllArticles();

    ArticleDto findOneByIdArticle(long id)throws ArticleNotFoundException;

    List<ArticleDto> searchByKeywordArticle(String keyword);
}

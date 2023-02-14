package com.example.demo.daoHibernate.Interfaces;


import com.example.demo.dao.domain.Article;

public interface IArticle {
    void create();
    void delete() ;
    void update() ;
    Article search(Long id) ;
}

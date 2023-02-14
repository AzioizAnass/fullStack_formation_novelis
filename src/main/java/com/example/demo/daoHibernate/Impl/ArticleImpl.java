package com.example.demo.daoHibernate.Impl;

import com.example.demo.dao.domain.Article;
import com.example.demo.daoHibernate.Interfaces.IArticle;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ArticleImpl implements IArticle {

    private StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    private Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
    private SessionFactory factory = meta.getSessionFactoryBuilder().build();

    @Override
    public void create() {
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        Article user=new Article();
        user.setTitre("breaking news");
        user.setArticleContent("password");
        session.persist(user);
        try {
            transaction.commit();
            System.out.println("article saved ");
        }catch (Exception e)
        {
            transaction.rollback();
            System.out.println("echec");
        }
        finally {
            session.close();
        }
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        Article c=new Article();
        c.setTitre("bla bla bla");
        c.setArticleContent("content");
        session.merge(c);
        try {
            transaction.commit();
            System.out.print("article updated ");
        }catch (Exception e)
        {
            transaction.rollback();
            System.out.print("article not updated");
        }
        finally {
            session.close();
        }
    }

    @Override
    public Article search(Long id) {
        Session session=factory.openSession();
        Article article=session.get(Article.class,id);
        session.close();
        return article;
    }
}

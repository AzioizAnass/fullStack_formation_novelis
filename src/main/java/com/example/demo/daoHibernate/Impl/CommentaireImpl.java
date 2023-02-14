package com.example.demo.daoHibernate.Impl;

import com.example.demo.dao.domain.Commentaire;
import com.example.demo.daoHibernate.Interfaces.ICommentaire;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CommentaireImpl implements ICommentaire {
    private StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    private Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
    private SessionFactory factory = meta.getSessionFactoryBuilder().build();

    @Override
    public void create() {
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        Commentaire c=new Commentaire();
        c.setCommentContent("bla bla bla");
        c.setCommentDate("12/3/2022");
        session.persist(c);
        try {
            transaction.commit();
            System.out.print("comment saved ");
        }catch (Exception e)
        {
            transaction.rollback();
            System.out.print("comment not saved ");
        }
        finally {
            session.close();
        }
    }

    @Override
    public void update() {
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        Commentaire c=new Commentaire();
        c.setCommentContent("bla bla bla");
        c.setCommentDate("31/3/2022");
        session.merge(c);
        try {
            transaction.commit();
            System.out.print("comment updated ");
        }catch (Exception e)
        {
            transaction.rollback();
            System.out.print("comment not updated");
        }
        finally {
            session.close();
        }
    }

    @Override
    public void delete() {
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        Commentaire c=new Commentaire();
        c.setCommentContent("bla bla bla");
        c.setCommentDate("12/3/2022");
        session.remove(c);
        try {
            transaction.commit();
            System.out.print("comment deleted ");
        }catch (Exception e)
        {
            transaction.rollback();
            System.out.print("comment not deleted ");
        }
        finally {
            session.close();
        }
    }

    @Override
    public Commentaire findById(Long id) {
        Session session=factory.openSession();
        Commentaire c=session.get(Commentaire.class,id);
        session.close();
        return c;
    }
}

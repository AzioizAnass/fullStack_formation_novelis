package com.example.demo.daoHibernate.Impl;

import com.example.demo.dao.domain.Utilisateur;
import com.example.demo.daoHibernate.Interfaces.IUtilisateur;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class UtilisateurImpl implements IUtilisateur {
    private StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    private Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
    private SessionFactory factory = meta.getSessionFactoryBuilder().build();
    @Override
    public void create() {
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        Utilisateur user=new Utilisateur();
        user.setUsername("username");
        user.setPassword("password");
        session.persist(user);
        try {
            transaction.commit();
            System.out.println("person saved ");
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
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        Utilisateur c=new Utilisateur();
        c.setUsername("pacmann100");
        c.setPassword("mouad124");
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
    public void update() {
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        Utilisateur user=new Utilisateur();
        user.setPassword("mouad123");
        user.setUsername("pacman99");
        session.merge(user);
        try {
            transaction.commit();
            System.out.print("user updated ");
        }catch (Exception e)
        {
            transaction.rollback();
            System.out.print("user not updated");
        }
        finally {
            session.close();
        }
    }

    @Override
    public Utilisateur search(Long id) {
        Session session=factory.openSession();
        Utilisateur user=session.get(Utilisateur.class,id);
        session.close();
        return user;
    }
}

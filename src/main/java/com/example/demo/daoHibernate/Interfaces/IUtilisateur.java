package com.example.demo.daoHibernate.Interfaces;


import com.example.demo.dao.domain.Utilisateur;

public interface IUtilisateur  {
    void create();
    void delete() ;
    void update() ;
    Utilisateur search(Long id) ;
}

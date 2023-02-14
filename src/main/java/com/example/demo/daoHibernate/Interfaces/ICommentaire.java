package com.example.demo.daoHibernate.Interfaces;


import com.example.demo.dao.domain.Commentaire;

public interface ICommentaire {
    public void create() ;
    public void update();
    public void delete();
    public Commentaire findById(Long id);
}

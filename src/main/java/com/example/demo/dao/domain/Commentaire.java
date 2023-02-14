package com.example.demo.dao.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column
    private String commentDate;
    @Column
    private String commentContent;

    @ManyToOne
    @JoinColumn(name = "articleid", nullable = false)
    private Article article;
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private Utilisateur utilisateur;



}

package com.example.demo.dao.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String roles;
    @OneToMany(mappedBy = "utilisateur")
    private Set<Commentaire> commenatires ;
}

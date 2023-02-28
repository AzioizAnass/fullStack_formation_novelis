package com.example.demo.dao.repository;


import com.example.demo.dao.domain.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateuRepository extends JpaRepository<Utilisateur, Long>{
Optional<Utilisateur> findByUsername(String username);
}

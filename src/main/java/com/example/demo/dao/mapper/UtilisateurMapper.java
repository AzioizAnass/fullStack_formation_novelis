package com.example.demo.dao.mapper;

import com.example.demo.dao.domain.Utilisateur;
import com.example.demo.dao.dto.UtilisateurDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    UtilisateurDto UtilisateurToUtilisateurDTO (Utilisateur user);
    Utilisateur UtilisateurDTOToUtilisateur (UtilisateurDto userDTO);
    Utilisateur upDateUtilisateurFromDto(UtilisateurDto userDTO ,@MappingTarget Utilisateur user);
    List<UtilisateurDto> mapToUsers(List<Utilisateur> userEntityList);
}


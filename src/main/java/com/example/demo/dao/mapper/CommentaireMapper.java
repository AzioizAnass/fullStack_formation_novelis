package com.example.demo.dao.mapper;

import com.example.demo.dao.domain.Commentaire;
import com.example.demo.dao.dto.CommentaireDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface CommentaireMapper {
    @Mapping(target = "article",source="article",ignore = true )
    CommentaireDto CommentaireToCommentaireDTO (Commentaire cmnt);
    Commentaire  CommentaireDTOToCommentaire (CommentaireDto cmnt);
    Commentaire upDateCommentaireFromDto(CommentaireDto cmntDTO , @MappingTarget Commentaire cmnt);
    List<CommentaireDto> mapToCommentaires(List<Commentaire> commentaireEntityList);
}

package com.example.demo.service.serviceInterfaces;
import com.example.demo.dao.dto.CommentaireDto;
import com.example.demo.exceptionsHandler.exceptions.CommentaireNotFoundException;

import java.util.List;

public interface ICommentaireService {
    CommentaireDto saveCommentaire(CommentaireDto cmnt);

    CommentaireDto updateCommentaire(CommentaireDto cmntDto, Long id);

    String deleteCommentaire(Long id);

    List<CommentaireDto> findAllCommentaires();

    CommentaireDto findCommentaireById(long id) throws CommentaireNotFoundException;
}

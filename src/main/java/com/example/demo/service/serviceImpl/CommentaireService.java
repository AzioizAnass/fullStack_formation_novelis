package com.example.demo.service.serviceImpl;

import com.example.demo.dao.domain.Commentaire;
import com.example.demo.dao.dto.CommentaireDto;
import com.example.demo.dao.repository.CommentaireRepository;
import com.example.demo.dao.mapper.CommentaireMapper;


import com.example.demo.exceptionsHandler.exceptions.CommentaireNotFoundException;
import com.example.demo.service.serviceInterfaces.ICommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentaireService implements ICommentaireService {
    @Autowired
    CommentaireRepository commentaireRepository ;
    @Autowired
    CommentaireMapper commentaireMapper ;
    @Override
    public CommentaireDto saveCommentaire(CommentaireDto commentaireDto) {

        Commentaire comment = commentaireRepository.save(commentaireMapper.CommentaireDTOToCommentaire(commentaireDto));
        return commentaireMapper.CommentaireToCommentaireDTO(comment);    }

    @Override
    public CommentaireDto updateCommentaire(CommentaireDto cmntDto,Long id) {
        Commentaire cmnt = commentaireMapper.CommentaireDTOToCommentaire(cmntDto);
        cmnt.setCommentId(id);
        commentaireRepository.save(cmnt);
        return commentaireMapper.CommentaireToCommentaireDTO(cmnt);    }

    @Override
    public String deleteCommentaire(Long id) {
        commentaireRepository.deleteById(id);
        return "delete success";    }

    @Override
    public List<CommentaireDto> findAllCommentaires() {
        return commentaireMapper.mapToCommentaires(commentaireRepository.findAll());
    }

    @Override
    public CommentaireDto findCommentaireById(long id) throws CommentaireNotFoundException {

        return Optional.of(commentaireMapper.CommentaireToCommentaireDTO(commentaireRepository.findById(id).orElseThrow(()->new CommentaireNotFoundException(id)))).get();
    }}
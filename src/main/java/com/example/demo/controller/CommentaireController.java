package com.example.demo.controller;


import com.example.demo.dao.dto.CommentaireDto;
import com.example.demo.exceptionsHandler.exceptions.CommentaireNotFoundException;
import com.example.demo.service.serviceImpl.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("comments")
public class CommentaireController {
    @Autowired
    private CommentaireService commentaireService;
    @Autowired
    public CommentaireController(CommentaireService commentaireService){
        this.commentaireService = commentaireService ;
    }
    @PostMapping(value = "/save")
    public CommentaireDto saveComment(@RequestBody CommentaireDto cmnt) {
        return commentaireService.saveCommentaire(cmnt);
    }

    @PutMapping(value = "/update/{id}")
    public CommentaireDto updateComment(@RequestBody CommentaireDto cmnt,@PathVariable("id") Long id) {

        return commentaireService.updateCommentaire(cmnt,id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        return commentaireService.deleteCommentaire(id);
    }
    @GetMapping(value="/getAll")
    public List<CommentaireDto> findAll(){
        return commentaireService.findAllCommentaires();
    }

    @GetMapping(value = "/{id}")
    public CommentaireDto getComment(@PathVariable("id") Long id) throws CommentaireNotFoundException {
        return commentaireService.findCommentaireById(id) ;
    }

}


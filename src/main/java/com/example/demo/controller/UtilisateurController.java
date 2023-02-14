package com.example.demo.controller;

import com.example.demo.dao.dto.CommentaireDto;
import com.example.demo.dao.dto.UtilisateurDto;
import com.example.demo.dao.repository.UtilisateuRepository;
import com.example.demo.exceptionsHandler.exceptions.UserNotFoundException;
import com.example.demo.service.serviceImpl.CommentaireService;
import com.example.demo.service.serviceImpl.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private CommentaireService commentaireService;
    @Autowired
    UtilisateuRepository userRepository;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
    @PostMapping(value = "/save")
    public UtilisateurDto saveUser(@RequestBody UtilisateurDto user) {
        return utilisateurService.saveUser(user);
    }
    @PutMapping(value = "/update/{id}")
    public UtilisateurDto updateUser(@RequestBody UtilisateurDto user, @PathVariable("id") Long id) {
          return utilisateurService.updateUser(user, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        return utilisateurService.deleteUser(id);
    }

    @GetMapping(value = "/getAll")
    public List<UtilisateurDto> findAll() {
        return utilisateurService.findAllUsers();
    }

    @GetMapping(value = "/{id}")
    public UtilisateurDto getUser(@PathVariable("id") Long id)throws UserNotFoundException{
        return utilisateurService.findUserById(id);
    }

    @PostMapping(value ="/addComnt")
    public CommentaireDto addComment(@RequestBody CommentaireDto cmntDto){
        return commentaireService.saveCommentaire(cmntDto);
    }

}
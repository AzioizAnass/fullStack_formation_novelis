package com.example.demo.controller;

import com.example.demo.dao.domain.Utilisateur;
import com.example.demo.dao.dto.AuthRequest;
import com.example.demo.dao.dto.CommentaireDto;
import com.example.demo.dao.dto.UtilisateurDto;
import com.example.demo.dao.repository.UtilisateuRepository;
import com.example.demo.exceptionsHandler.exceptions.UserNotFoundException;
import com.example.demo.service.serviceImpl.CommentaireService;
import com.example.demo.service.serviceImpl.JwtService;
import com.example.demo.service.serviceImpl.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
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
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
    @PostMapping(value = "/addUser")
    public String saveUser(@RequestBody Utilisateur user) {
        utilisateurService.addUser(user);
        return jwtService.generateToken(user.getUsername());
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

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value ="/addComnt")
    public CommentaireDto addComment(@RequestBody CommentaireDto cmntDto){
        return commentaireService.saveCommentaire(cmntDto);
    }
    @PostMapping("/login")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
}
    @GetMapping("/token/{token}")
    public UtilisateurDto findUserFromToken(@PathVariable String token)throws UserNotFoundException{
        return utilisateurService.findByToken(token) ;
    }
    @GetMapping("/getByUsername/{username}")
    public UtilisateurDto findByUsername(@PathVariable String username){
        return utilisateurService.findByUsername(username);
    }
}
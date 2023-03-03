package com.example.demo.service.serviceInterfaces;

import com.example.demo.dao.dto.AuthRequest;
import com.example.demo.dao.dto.UtilisateurDto;
import com.example.demo.exceptionsHandler.exceptions.UserNotFoundException;

import java.util.List;

public interface IUtilisateurService {
    UtilisateurDto saveUser(AuthRequest user);

    public UtilisateurDto updateUser(UtilisateurDto userDto,Long id);

    String deleteUser(Long id);

    List<UtilisateurDto> findAllUsers();

    UtilisateurDto findUserById(long id) throws UserNotFoundException;
}

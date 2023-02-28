package com.example.demo.service.serviceImpl;


import com.example.demo.dao.domain.Utilisateur;
import com.example.demo.dao.dto.UtilisateurDto;
import com.example.demo.dao.repository.UtilisateuRepository;
import com.example.demo.dao.mapper.UtilisateurMapper;
import com.example.demo.exceptionsHandler.exceptions.UserNotFoundException;
import com.example.demo.service.serviceInterfaces.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService implements IUtilisateurService {
    @Autowired
    UtilisateuRepository userRepository ;
    @Autowired
    UtilisateurMapper userMapper ;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Override
    public UtilisateurDto saveUser(UtilisateurDto user) {
        return userMapper.UtilisateurToUtilisateurDTO(userRepository.save(userMapper.UtilisateurDTOToUtilisateur(user)));
    }

    @Override
    public UtilisateurDto updateUser(UtilisateurDto userDto,Long id) {
        Utilisateur user = userMapper.UtilisateurDTOToUtilisateur(userDto);
        user.setUserid(id);
        return userMapper.UtilisateurToUtilisateurDTO(user);
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "Delete sueccess";

    }

    @Override
    public List<UtilisateurDto> findAllUsers() {
        return userMapper.mapToUsers(userRepository.findAll());
    }

    @Override
    public UtilisateurDto findUserById(long id) throws UserNotFoundException{
        return Optional.of(userMapper.UtilisateurToUtilisateurDTO(userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id)))).get();
}
    public String addUser(Utilisateur userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userRepository.save(userInfo);
        return "user added to system ";
    }
    public UtilisateurDto findByUsername(String str){
        return userMapper.UtilisateurToUtilisateurDTO(userRepository.findByUsername(str).get());
    }

    public UtilisateurDto findByToken(String token)throws UserNotFoundException {
        return userMapper.UtilisateurToUtilisateurDTO(userRepository.findByUsername(jwtService.extractUsername(token)).orElseThrow(()->new UserNotFoundException(1)));
    }
}

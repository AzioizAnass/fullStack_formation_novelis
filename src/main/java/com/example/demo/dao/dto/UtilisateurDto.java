package com.example.demo.dao.dto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UtilisateurDto {

    private long userid;
    public String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;

}

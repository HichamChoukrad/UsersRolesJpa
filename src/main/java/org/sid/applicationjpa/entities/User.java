package org.sid.applicationjpa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "USERS")  //cette annotation n'est pas obligatoire, mais au moment lorsqu'on va déclarer un groupe ou ien description, Faut il l'ajouter

@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    private String userId;
    @Column(name ="USER_NAME" ,unique = true, length = 20) //C'est un index unique, Je veux pas avoir deux user qui ont le meme username
    private String userName;
    private String password;
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<Role> roles=new ArrayList<>(); //Lorsque Nous utilisons EAGER, faut ajouter une ArrayList
}

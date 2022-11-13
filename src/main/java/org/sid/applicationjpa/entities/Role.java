package org.sid.applicationjpa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String desc;
    @Column( unique = true, length = 20)
    private String roleName;
    @ManyToMany(fetch = FetchType.EAGER)
    /* @JoinTable(name = "USERS_ROLES") //pour le nom de la table de jointure */
    private List<User> users=new ArrayList<>(); //Lorsque Nous utilisons EAGER, faut ajouter une ArrayList
}

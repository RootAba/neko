package com.example.neko.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "publication",
        uniqueConstraints = {
              //  @UniqueConstraint(columnNames = "numero"),
                //    @UniqueConstraint(columnNames = "email")
        })

//@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class Publications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
/*
    @JsonIgnore
    @OneToMany(mappedBy = "publications")
    List<Commentaires> commentaires = new ArrayList<>();-*/


    @ManyToOne
    private Utilisateur utilisateur;
}

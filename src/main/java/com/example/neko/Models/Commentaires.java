package com.example.neko.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Commentaires {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenu;

    @ManyToOne
    private Annonces annonces;
    //Utilisateur peut faire plusieru commentaire

    @ManyToOne
    private Publications publications;


    @ManyToOne
    private Utilisateur commentateur;
}

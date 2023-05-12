package com.example.neko.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Annonces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String annonce;
    private String image;
/*
    @JsonIgnore
    @OneToMany(mappedBy = "annonces")
    List<Commentaires> commentaires = new ArrayList<>();*/


    @ManyToOne
    private Entreprise entreprise;

}

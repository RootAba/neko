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
public class Entreprise extends Utilisateur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String domaine;

    @ManyToOne
    private Domaineactivite domaineactivite;

    @JsonIgnore
    @OneToMany(mappedBy = "entreprise")
    List<Annonces> annonces = new ArrayList<>();
}

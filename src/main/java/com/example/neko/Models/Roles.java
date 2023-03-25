package com.example.neko.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Roles {
   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String libelle;*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole nom;

    public Roles() {

    }

    public Roles(ERole name) {
        this.nom = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERole getNom() {
        return nom;
    }

    public void setNom(ERole nom) {
        this.nom = nom;
    }

    /*
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    List<Alumnis> alumnis = new ArrayList<>();*/

  /*  @JsonIgnore
    @OneToMany(mappedBy = "role")
    List<Administrateurs> administrateurs = new ArrayList<>();*/
}


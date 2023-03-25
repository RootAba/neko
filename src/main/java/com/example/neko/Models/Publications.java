package com.example.neko.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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


    @ManyToOne
    private Utilisateur utilisateur;
}

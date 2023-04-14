package com.example.neko.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.servlet.http.Part;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Utilisateur",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "numero"),
            //    @UniqueConstraint(columnNames = "email")
        })

//@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {

  /*  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String username;
   // private String prenom;
    private String numero;
    private String email;
    private String mdp;*/


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;


    @NotBlank
    @Size(max = 20)
    private String nom;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 50)
    @Email
    private String numero;

    @NotBlank
    @Size(max = 120)
    private String password;



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "utilisateur_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();


    //==========Roles ==================
    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public Utilisateur(String username, String email,String nom,String numero, String password) {
        this.username = username;
        this.email = email;
        this.nom=nom;
        this.numero=numero;
        this.password = password;
    }


    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur")
    List<PubStory> pubStory = new ArrayList<>();


    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur")
    List<Commentaires> commentaires = new ArrayList<>();




    @ManyToMany
    @JoinTable(name = "Utilisateurchat", joinColumns = {
            @JoinColumn(name = "id_utilisateur") }, inverseJoinColumns = {
            @JoinColumn(name = "id_message") })
    List<Chat> chat = new ArrayList<>();

    //================Apple video ================
    @ManyToMany(mappedBy = "utilisateurs")
    private Set<Appelvideo> appelvideos = new HashSet<>();

    @OneToMany(mappedBy = "utilisateur")
    private Set<Participantappelvideo> participantappelvideos = new HashSet<>();


    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur")
    List<Publications> publications = new ArrayList<>();


    // =============== iNvitation ===============
    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur")
    List<Invitations> invitations = new ArrayList<>();
    //=============Auto association ===============

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "amis", joinColumns = {
            @JoinColumn(name = "id_utilisateur") }, inverseJoinColumns = {
            @JoinColumn(name = "id_ami") })
    private Set<Utilisateur> amis = new HashSet<>();

  /*  @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Category> children = new ArrayList<>();*/
}

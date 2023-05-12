package com.example.neko;

import com.example.neko.Models.Roles;
import com.example.neko.Models.Utilisateur;
import com.example.neko.Services.RoleService;
import com.example.neko.Services.UtilisateurService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import static com.example.neko.Models.ERole.*;

@SpringBootApplication
public class NekoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =	SpringApplication.run(NekoApplication.class, args);


		RoleService roleService = ctx.getBean(RoleService.class);
		UtilisateurService utilisateurService  = ctx.getBean(UtilisateurService.class);


		Roles utilisateurs = new Roles();
		utilisateurs.setId(1);
		utilisateurs.setName(ROLE_USER);

		Roles admin = new Roles();
		admin.setId(2);
		admin.setName(ROLE_ADMIN);

		roleService.AjouterRole(utilisateurs);
		roleService.AjouterRole(admin);

		Roles userRole = roleService.AfficherRoleParLibelle(ROLE_ADMIN)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));

		/* ==================Role entreprise ===================*/
		Roles entreprise = new Roles();
		entreprise.setId(3);
		entreprise.setName(ROLE_ENTREPRISE);
		roleService.AjouterRole(entreprise);

		/* ==================Role ARTISTE ===================*/
		Roles artiste = new Roles();
		artiste.setId(4);
		artiste.setName(ROLE_ARTISTE);
		roleService.AjouterRole(artiste);


		/* ==================Role Commerce ===================*/
		Roles commerce = new Roles();
		commerce.setId(5);
		commerce.setName(ROLE_COMMERCE);
		roleService.AjouterRole(commerce);


		/* ==================Role EMPLOI ===================*/
		Roles emploi = new Roles();
		emploi.setId(6);
		emploi.setName(ROLE_EMPLOI);
		roleService.AjouterRole(emploi);

		Roles sport = new Roles();
		sport.setId(7);
		sport.setName(ROLE_SPORT);
		roleService.AjouterRole(sport);



	/*	Utilisateur abba = new Utilisateur();
		abba.setNom("abasse");
		abba.setUsername("aba");
		abba.setPassword("Abassemaiga");
		abba.setEmail("abasse@gmail.com");
		abba.setNumero("72225182");
	abba.getRoles().add(userRole);
		utilisateurService.Creer(abba);*/
	}


}

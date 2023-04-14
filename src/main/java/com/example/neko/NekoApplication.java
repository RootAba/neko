package com.example.neko;

import com.example.neko.Models.Roles;
import com.example.neko.Models.Utilisateur;
import com.example.neko.Services.RoleService;
import com.example.neko.Services.UtilisateurService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import static com.example.neko.Models.ERole.ROLE_ADMIN;
import static com.example.neko.Models.ERole.ROLE_USER;

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

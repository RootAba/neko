package com.example.neko;

import com.example.neko.Models.Roles;
import com.example.neko.Services.RoleService;
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



		Roles utilisateurs = new Roles();
		utilisateurs.setId(1);
		utilisateurs.setNom(ROLE_USER);

		Roles admin = new Roles();
		admin.setId(2);
		admin.setNom(ROLE_ADMIN);

		roleService.AjouterRole(utilisateurs);
		roleService.AjouterRole(admin);
	}


}

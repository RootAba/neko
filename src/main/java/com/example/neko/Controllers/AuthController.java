package com.example.neko.Controllers;


import com.example.neko.Models.ERole;
import com.example.neko.Models.Roles;
import com.example.neko.Models.Utilisateur;
import com.example.neko.Repository.RolesRepository;
import com.example.neko.Repository.UtilisateurRepository;

import com.example.neko.payload.request.LoginRequest;
import com.example.neko.payload.request.SignupRequest;
import com.example.neko.payload.response.JwtResponse;
import com.example.neko.payload.response.MessageResponse;
import com.example.neko.security.services.UserDetailsImpl;
import com.example.neko.security.services.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


//@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8100"} ,allowCredentials = "true",maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UtilisateurRepository userRepository;

  @Autowired
  RolesRepository roleRepository;



  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;


  @GetMapping("/essai")
  public String aba(){
    return "Bienvenue abba";
  }

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt,
            userDetails.getId(),
            userDetails.getUsername(),
            userDetails.getEmail(),
            roles));


  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    Utilisateur user = new Utilisateur(signUpRequest.getUsername(),
            signUpRequest.getEmail(),signUpRequest.getNom(),signUpRequest.getNumero(),
            encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();
    Set<Roles> roles = new HashSet<>();

    if (strRoles == null) {
      Roles userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
          case "admin":
            Roles adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(adminRole);
            break;
          case "artiste":
            Roles artRole = roleRepository.findByName(ERole.ROLE_ARTISTE)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(artRole);
            break;

          case "entreprise":
            Roles entreRole = roleRepository.findByName(ERole.ROLE_ENTREPRISE)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(entreRole);
            break;

          case "emploi":
            Roles empRole = roleRepository.findByName(ERole.ROLE_EMPLOI)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(empRole);
            break;

          case "commerce":
            Roles commRole = roleRepository.findByName(ERole.ROLE_COMMERCE)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(commRole);
            break;

          default:
            Roles userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
}

package com.example.neko.Repository;

import com.example.neko.Models.ERole;
import com.example.neko.Models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Integer> {
   // Roles findByName(String name);
    Optional<Roles> findByName(ERole name);
}

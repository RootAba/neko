package com.example.neko.Repository;

import com.example.neko.Models.Invitations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationRepository extends JpaRepository<Invitations,Long> {
}

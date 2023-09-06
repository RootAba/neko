package com.example.neko.Repository;

import com.example.neko.Models.Commentaires;
import com.example.neko.Models.Publications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaires,Long> {
    //Commentaires findByCommentaire(String name);
    List<Commentaires> findByPublications(Publications publications);
    @Query(value = "SELECT DISTINCT c.* FROM commentaires c WHERE c.publications_id =:publicationsId", nativeQuery = true)
    List<Commentaires> findByPublicationsId(@PathVariable Long publicationsId);
}

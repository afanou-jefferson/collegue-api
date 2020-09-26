package dev.collegue.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import dev.collegue.entity.Collegue;

public interface CollegueRepo extends JpaRepository<Collegue, Integer> {

	List<Optional<Collegue>> findByNom(@Param("nom") String nom);

	Optional<Collegue> findByMatricule(String matricule);

}

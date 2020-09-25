package dev.collegue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.collegue.entity.Collegue;

public interface CollegueRepo extends JpaRepository<Collegue, Integer> {

	@Query("select c.matricule from Collegue c where c.nom=:nom")
	List<String> findByNom(@Param("nom") String nom);

}

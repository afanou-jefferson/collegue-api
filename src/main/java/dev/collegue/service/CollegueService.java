package dev.collegue.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.collegue.dto.CreerCollegueRequestDto;
import dev.collegue.entity.Collegue;
import dev.collegue.repository.CollegueRepo;

@Service
public class CollegueService {

	private CollegueRepo collegueRepo;

	public CollegueService(CollegueRepo collegueRepo) {
		super();
		this.collegueRepo = collegueRepo;
	}

	public List<String> rechercherParNom(String nom) {
		return collegueRepo.findByNom(nom);
	}

	public Collegue creerCollegue(CreerCollegueRequestDto dto) {

		Collegue collegue = new Collegue();
		collegue.setNom(dto.getNom());
		collegue.setPrenom(dto.getPrenoms());
		collegue.setDateDeNaissance(dto.getDateDeNaissance());
		collegue.setPhotoUrl(dto.getPhotoUrl());

		// logique métier (génération du matricule)
		collegue.setMatricule(UUID.randomUUID().toString());
		collegue.setEmail(dto.getPrenoms() + "." + dto.getNom() + "@dev.fr");

		// => envoyer un email aux RHs
		// ...

		return this.collegueRepo.save(collegue);// insert into collegue

	}

}

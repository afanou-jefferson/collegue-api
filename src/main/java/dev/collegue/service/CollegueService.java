package dev.collegue.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.collegue.dto.CreerCollegueRequestDto;
import dev.collegue.dto.GetCollegueByNomResponseDto;
import dev.collegue.entity.Collegue;
import dev.collegue.repository.CollegueRepo;

@Service
public class CollegueService {

	private CollegueRepo collegueRepo;

	public CollegueService(CollegueRepo collegueRepo) {
		super();
		this.collegueRepo = collegueRepo;
	}

	public List<GetCollegueByNomResponseDto> rechercherParNom(String nom) {

		List<GetCollegueByNomResponseDto> listeDto = new ArrayList<>();

		List<Optional<Collegue>> listeResponse = collegueRepo.findByNom(nom);

		if (!listeResponse.isEmpty()) {
			for (Optional<Collegue> collegue : listeResponse) {

				GetCollegueByNomResponseDto newDto = new GetCollegueByNomResponseDto(collegue.get().getNom(),
						collegue.get().getMatricule());
				listeDto.add(newDto);
			}
		}

		return listeDto;
	}

	public Optional<Collegue> rechercherParMatricule(String matricule) {
		return collegueRepo.findByMatricule(matricule);
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

		return this.collegueRepo.save(collegue);// insert into collegue

	}

}

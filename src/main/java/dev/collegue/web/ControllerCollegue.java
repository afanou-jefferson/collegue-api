package dev.collegue.web;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegue.dto.GetCollegueByNomResponseDto;
import dev.collegue.entity.Collegue;
import dev.collegue.service.CollegueService;

@RestController // == @ResponseBody + @controller
@RequestMapping("collegues") // rootUrl/collegues... appel ce controlleur par défaut
public class ControllerCollegue {

	private CollegueService collegueService;

	public ControllerCollegue(CollegueService collegueService) {
		super();
		this.collegueService = collegueService;
	}

	// Get /collegues
	@GetMapping
	public ResponseEntity<?> rechercherMatriculeParNom(@RequestParam String nom) { // ?nom=....

		List<GetCollegueByNomResponseDto> listeCollegueRespDto = this.collegueService.rechercherParNom(nom);

		if (!listeCollegueRespDto.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(listeCollegueRespDto);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nom de Collegue introuvable . . .");
		}
	}

	@GetMapping("{matricule}") // == collegues/matricule
	public ResponseEntity<?> rechercherCollegueParMatricule(@PathVariable String matricule) {

		Optional<Collegue> collegueDuMatricule = this.collegueService.rechercherParMatricule(matricule);

		if (!collegueDuMatricule.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(collegueDuMatricule);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Collegue non trouvé avec ce Matricule . . .");
		}

	}

}

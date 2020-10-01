package dev.collegue.web;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegue.dto.CreerCollegueRequestDto;
import dev.collegue.dto.MatriculePhotoUrlResponseDto;
import dev.collegue.dto.UpdateCollegueRequestDto;
import dev.collegue.entity.Collegue;
import dev.collegue.service.CollegueService;

@CrossOrigin
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

		List<String> listeCollegueRespDto = this.collegueService.rechercherParNom(nom);

		if (!listeCollegueRespDto.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(listeCollegueRespDto);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nom de Collegue introuvable . . .");
		}
	}

	@GetMapping("{matricule}") // == collegues/${matricule}
	public ResponseEntity<?> rechercherCollegueParMatricule(@PathVariable String matricule) {

		Optional<Collegue> collegueDuMatricule = this.collegueService.rechercherParMatricule(matricule);

		if (collegueDuMatricule.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(collegueDuMatricule);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Collegue non trouvé avec ce Matricule . . .");
		}
	}

	@RequestMapping("/photos") // == url/collegues/photos
	public ResponseEntity<?> getAllPhotosCollegues() {

		ArrayList<MatriculePhotoUrlResponseDto> ensembleUrlPhotos = this.collegueService.getAllPhotosUrl();

		if (!ensembleUrlPhotos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(ensembleUrlPhotos);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Pas de collegues trouvés . . .");
		}
	}

	@PostMapping
	public ResponseEntity<?> creerCollegue(@RequestBody CreerCollegueRequestDto requestDto) {

		Collegue collegueInserted = this.collegueService.creerCollegue(requestDto);

		if (collegueInserted != null) {
			return ResponseEntity.status(HttpStatus.OK).body(collegueInserted);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Echec lors de la création du nouveau collegue . . .");
		}
	}

	@PutMapping("collegues/update")
	public ResponseEntity<?> updateCollegue(@Valid @RequestBody UpdateCollegueRequestDto dtoRequest,
			BindingResult resValid) throws ParseException {
		if (!resValid.hasErrors()) {
			Collegue response1 = this.collegueService.updateCollegue(dtoRequest);
			return ResponseEntity.ok().body(response1);
		} else {
			return ResponseEntity.badRequest().body("Une erreur est survenue lors de l'update du Collegue");
		}
	}

}

package dev.collegue.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public List<String> rechercherMatriculeParNom(@RequestParam String nom) { // ?nom=?
		return this.collegueService.rechercherParNom(nom);
	}

}

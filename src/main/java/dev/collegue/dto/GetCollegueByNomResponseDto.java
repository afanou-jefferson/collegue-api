package dev.collegue.dto;

public class GetCollegueByNomResponseDto {

	String nom;

	String matricule;

	public GetCollegueByNomResponseDto() {
	}

	public GetCollegueByNomResponseDto(String nom, String matricule) {
		this.nom = nom;
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

}

package dev.collegue.dto;

public class GetCollegueByNomResponseDto {

	String matricule;

	public GetCollegueByNomResponseDto() {
	}

	public GetCollegueByNomResponseDto(String matricule) {

		this.matricule = matricule;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

}

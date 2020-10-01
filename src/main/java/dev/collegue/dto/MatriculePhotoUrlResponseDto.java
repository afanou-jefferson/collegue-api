package dev.collegue.dto;

public class MatriculePhotoUrlResponseDto {

	private String matricule;
	private String photoUrl;

	public MatriculePhotoUrlResponseDto(String matricule, String photoUrl) {
		super();
		this.matricule = matricule;
		this.photoUrl = photoUrl;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

}

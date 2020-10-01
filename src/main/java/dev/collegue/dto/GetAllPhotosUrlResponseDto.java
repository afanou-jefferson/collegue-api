package dev.collegue.dto;

import java.util.ArrayList;

public class GetAllPhotosUrlResponseDto {

	private ArrayList<MatriculePhotoUrlResponseDto> listeBinomesMatUrl;

	public GetAllPhotosUrlResponseDto() {
	};

	public GetAllPhotosUrlResponseDto(ArrayList<MatriculePhotoUrlResponseDto> listeBinomesMatUrl) {
		super();
		this.listeBinomesMatUrl = listeBinomesMatUrl;
	}

	public ArrayList<MatriculePhotoUrlResponseDto> getListeBinomesMatUrl() {
		return listeBinomesMatUrl;
	}

	public void setListeBinomesMatUrl(ArrayList<MatriculePhotoUrlResponseDto> listeBinomesMatUrl) {
		this.listeBinomesMatUrl = listeBinomesMatUrl;
	}

}

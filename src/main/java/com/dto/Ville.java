package com.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ville {
	private String codeCommune;
	private String nomCommune;
	private String codePostale;
	private String libelle;
	private String ligne_5;
	private String latitude;
	private String longitude;
	
	
	public Ville(String codeCommune, String nomCommune, String codePostale, String libelle, String ligne_5,
			String latitude, String longitude) {
		super();
		this.codeCommune = codeCommune;
		this.nomCommune = nomCommune;
		this.codePostale = codePostale;
		this.libelle = libelle;
		this.ligne_5 = ligne_5;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	

	public String getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getLigne_5() {
		return ligne_5;
	}

	public void setLigne_5(String ligne_5) {
		this.ligne_5 = ligne_5;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public String getCodeCommune() {
		return codeCommune;
	}

	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}
	

}

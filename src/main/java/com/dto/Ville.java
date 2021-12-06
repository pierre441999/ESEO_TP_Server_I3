package com.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	private Coordonnees coord;
	
	
	public Ville(@JsonProperty("codeCommune") String codeCommune, @JsonProperty("nomCommune") String nomCommune,
			@JsonProperty("codePostale") String codePostale, @JsonProperty("libelle") String libelle,
			@JsonProperty("ligne_5") String ligne_5, @JsonProperty("coord") Coordonnees coord) {
		super();
		this.codeCommune = codeCommune;
		this.nomCommune = nomCommune;
		this.codePostale = codePostale;
		this.libelle = libelle;
		this.ligne_5 = ligne_5;
		this.coord = coord;
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
	public Coordonnees getCoord() {
		return coord;
	}

	public void setCoord(Coordonnees coord) {
		this.coord = coord;
	}

}

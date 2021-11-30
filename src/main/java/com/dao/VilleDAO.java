package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	
	//Ville findVille();
	public ArrayList<Ville> findAllVilles();
	public ArrayList<Ville> findSpecificVille(String nom_Commune);
	public void addVille(Ville ville);
	public void updateVille(Ville ville, String codeCommune);
	public void removeVille(String codeCommune);
		
	
}

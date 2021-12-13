package com.dao;

import java.util.List;

import com.dto.Ville;

public interface VilleDAO {
	
	//Ville findVille();
	public List<Ville> findAllVilles();
	public List<Ville> findSpecificVille(String code_Commune);
	public void addVille(Ville ville);
	public void updateVille(Ville ville, String codeCommune);
	public void removeVille(String codeCommune);
		
	
}

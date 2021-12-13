package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.Ville;

public interface VilleDAO {
	
	//Ville findVille();
	public List<Ville> findAllVilles() throws SQLException;
	public List<Ville> findSpecificVille(String code_Commune) throws SQLException;
	public void addVille(Ville ville) throws SQLException;
	public void updateVille(Ville ville, String codeCommune) throws SQLException;
	public void removeVille(String codeCommune) throws SQLException;
		
	
}

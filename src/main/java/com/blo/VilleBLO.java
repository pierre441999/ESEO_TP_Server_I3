package com.blo;

import java.sql.SQLException;
import java.util.List;

import com.dto.Ville;

public interface VilleBLO {

	public List<Ville> getInfoVille(String code_Commune) throws VilleException, SQLException;
	public void addInfoVille(Ville newVille) throws VilleException, SQLException;
	public void updateInfoVille(Ville ville, String codeCommune) throws VilleException, SQLException;
	public void removeInfoVille(String codeCommune) throws VilleException, SQLException;
}

package com.blo;

import java.util.List;

import com.dto.Ville;

public interface VilleBLO {

	public List<Ville> getInfoVille(String code_Commune) throws VilleException;
	public void addInfoVille(Ville newVille) throws VilleException;
	public void updateInfoVille(Ville ville, String codeCommune) throws VilleException;
	public void removeInfoVille(String codeCommune) throws VilleException;
}

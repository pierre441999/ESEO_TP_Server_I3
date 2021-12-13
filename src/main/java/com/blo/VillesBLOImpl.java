package com.blo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.config.BddConfig;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VillesBLOImpl implements VilleBLO {

	private VilleDAO villeDAO;

	public void init() {
		BddConfig bddConfig = BddConfig.getInstance();
		this.villeDAO = bddConfig.getVilleDao();
	}

	public List<Ville> getInfoVille(String codeCommune) {
		init();
		List<Ville> listVille;
		if (codeCommune != null) {
			listVille = villeDAO.findSpecificVille(codeCommune);
		} else {
			listVille = villeDAO.findAllVilles();

		}
		return listVille;

	}

	public void addInfoVille(Ville newVille) throws VilleException {

		init();
		villeDAO.addVille(newVille);

	}

	public void updateInfoVille(Ville ville, String codeCommune) {
		init();
		villeDAO.updateVille(ville, codeCommune);
	}

	@Override
	public void removeInfoVille(String codeCommune) {
		init();
		villeDAO.removeVille(codeCommune);

	}

}

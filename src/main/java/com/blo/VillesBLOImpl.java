package com.blo;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.config.BddConfig;
import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VillesBLOImpl implements VilleBLO {
	
	
	private VilleDAO villeDAO;

	public void init(){
		BddConfig bddConfig = BddConfig.getInstance();
		this.villeDAO = bddConfig.getVilleDao();
	}
//	@Autowired
//	private VilleDAO villeDAO;
	

	@Override
	public ArrayList<Ville> getInfoVille() throws VilleException{

		init();
		ArrayList<Ville> listVille;

		listVille = villeDAO.findAllVilles();
		System.out.println("Nombre de ville récupérée(s) : " + listVille.size());

		return listVille;
	}
	
	public void addInfoVille(Ville newVille) throws VilleException{

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

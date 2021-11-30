package com.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.blo.VilleException;
import com.dto.Ville;


@RestController
public class VilleController {
	private Logger logger = LoggerFactory.getLogger(VilleController.class);
	
	@Autowired
	VilleBLO villeBLOService;
	
	
	// Methode GET
		@RequestMapping(value = "/ville", method = RequestMethod.GET)
		@ResponseBody
		public ArrayList<Ville> appelGet() throws VilleException{
			System.out.println("Appel GET");
			

			return villeBLOService.getInfoVille();
		}
		
	    
		// Méthode POST
		@RequestMapping(value = "/ville", method = RequestMethod.POST)
		public void appelPost(@RequestBody Ville newVille) throws VilleException{
			System.out.println("Appel POST");
			villeBLOService.addInfoVille(newVille);
			logger.info("ville ajoutée");
		}
		
		// Méthode PUT
		@RequestMapping(value = "/ville", method = RequestMethod.PUT)
		public void appelPut(@RequestBody Ville newVille, @RequestParam(required = true, value = "codeCommune") String codeCommune) {
			System.out.println("Appel PUT");
			villeBLOService.updateInfoVille(newVille, codeCommune);
			logger.info("ville modifiée");
		}

		// Méthode DELETE
		@RequestMapping(value = "/ville", method = RequestMethod.DELETE)
		public void appelDelete(@RequestParam(required = true, value = "codeCommune") String codeCommune) {
			System.out.println("Appel DELETE");
			villeBLOService.removeInfoVille(codeCommune);
			logger.info("ville supprimée");
		}

		
		

}

package com.controller;

import java.util.List;

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
		public List<Ville> appelGet(@RequestParam(required = false, value = "codeCommune") String codeCommune) throws VilleException{

			return villeBLOService.getInfoVille(codeCommune);
		}

		
	    
		// Méthode POST
		@RequestMapping(value = "/ville", method = RequestMethod.POST)
		public void appelPost(@RequestBody Ville newVille) throws VilleException{
			villeBLOService.addInfoVille(newVille);
			logger.info("ville ajoutée");
		}
		
		// Méthode PUT
		@RequestMapping(value = "/ville", method = RequestMethod.PUT)
		public void appelPut(@RequestBody Ville newVille, @RequestParam(required = true, value = "codeCommune") String codeCommune) {
			villeBLOService.updateInfoVille(newVille, codeCommune);
			logger.info("ville modifiée");
		}

		// Méthode DELETE
		@RequestMapping(value = "/ville", method = RequestMethod.DELETE)
		public void appelDelete(@RequestParam(required = true, value = "codeCommune") String codeCommune) {
			villeBLOService.removeInfoVille(codeCommune);
			logger.info("ville supprimée");
		}

		
		

}

package com.mpaiements.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mpaiements.dao.PaiementDao;
import com.mpaiements.model.Paiement;
import com.mpaiements.web.controller.exceptions.PaiementExistantException;
import com.mpaiements.web.controller.exceptions.PaiementImpossibleException;

@RestController
public class PaiementController {

	@Autowired
	private PaiementDao paiementDao;

	@PostMapping(value = "/paiements")
	public ResponseEntity<Paiement> payerUneCommande(@RequestBody Paiement paiement) {
		
		Paiement paiementExistant = paiementDao.findByIdCommande(paiement.getIdCommande());
		if(paiementExistant != null) throw new PaiementExistantException("Cette commande est déjà payée");
			
		Paiement nouveauPaiement = paiementDao.save(paiement);
		if(nouveauPaiement == null) throw new PaiementImpossibleException("Erreur, impossible d'établir le paiement, réessayez plus tard");

		Paiement nouvelleCommande = paiementDao.save(paiement);
		
		 return new ResponseEntity<Paiement>(nouveauPaiement, HttpStatus.CREATED);
	}

}

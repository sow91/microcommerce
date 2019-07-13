package com.mcommandes.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcommandes.dao.CommandeDao;
import com.mcommandes.model.Commande;
import com.mcommandes.web.exceptions.ImpossibleAjouterCommandeException;

@RestController
public class CommandeController {

	@Autowired
	private CommandeDao commandeDao;

	@PostMapping(value = "/commandes")
	public ResponseEntity<Commande> ajouterCommande(@RequestBody Commande commande) {

		Commande nouvelleCommande = commandeDao.save(commande);
		
		if(nouvelleCommande == null) throw new ImpossibleAjouterCommandeException("Impossible d'ajouter cette commande");

		return new ResponseEntity<Commande>(commande, HttpStatus.CREATED);
	}

	@GetMapping(value = "/commandes/{id}")
	public Optional<Commande> recupererUneCommande(@PathVariable int id) {
		Optional<Commande> comande = commandeDao.findById(id);

		if(!comande.isPresent()) throw new CommandeNotFoundException("Cette commande n'existe pas");

		return comande;
	}

}

package com.mpaiements.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpaiements.model.Paiement;

public interface PaiementDao extends JpaRepository<Paiement, Integer>{

	Paiement findByIdCommande(Integer idCommande);

}

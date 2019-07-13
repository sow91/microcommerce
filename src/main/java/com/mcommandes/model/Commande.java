package com.mcommandes.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Commande {

	@Id
	@GeneratedValue
	private int id;
	private Integer productId;
	private Date dateCommande;
	private Integer quantite;
	private Boolean commandePayee;


	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(int id, Integer productId, Date dateCommande, Integer quantite, Boolean commandePayee) {
		super();
		this.id = id;
		this.productId = productId;
		this.dateCommande = dateCommande;
		this.quantite = quantite;
		this.commandePayee = commandePayee;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Boolean getCommandePayee() {
		return commandePayee;
	}

	public void setCommandePayee(Boolean commandePayee) {
		this.commandePayee = commandePayee;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", productId=" + productId + ", dateCommande=" + dateCommande + ", quantite="
				+ quantite + ", commandePayee=" + commandePayee + "]";
	}

	



}

package com.mproduits.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mproduits.dao.ProductDao;
import com.mproduits.model.Product;
import com.mproduits.web.exceptions.ProductNotFoundExcepion;

@RestController
public class ProductController {

	@Autowired
	private ProductDao productDao;

	@GetMapping(value = "/produits")
	public List<Product> listeDeProduits() {

		List<Product> products = productDao.findAll();

		if(products.isEmpty()) throw new ProductNotFoundExcepion("Aucun produit n'est disponible à la vente");

		return products;
	}

	@GetMapping(value = "/produits/{id}")
	public Optional<Product> recupererUnProduit(@PathVariable int id) {
		Optional<Product> product = productDao.findById(id);

		if(!product.isPresent()) throw new ProductNotFoundExcepion("Le produit correspondant à l'id \" + id + \" n'existe pas");

		return product;
	}

}

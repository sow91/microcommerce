package com.mproduits.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mproduits.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

}

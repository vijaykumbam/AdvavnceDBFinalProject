package com.rowan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rowan.model.Products;

@Repository
public interface ProductsI extends JpaRepository<Products, Integer> {
	
	
}

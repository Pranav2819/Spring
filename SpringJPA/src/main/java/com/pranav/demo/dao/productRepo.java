package com.pranav.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.pranav.demo.model.product;

public interface productRepo extends JpaRepository<Product, Integer> {

	
}

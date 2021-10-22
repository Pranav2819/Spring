package com.pranav.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pranav.demo.dao.ProductRepo;
import com.pranav.demo.model.Product;

@RestController
public class productController {
		
		@Autowired
		ProductRepo repo;
	
	
		@RequestMapping("/")
		public String home()
		{
			return "home.jsp";
		}
		
		@DeleteMapping("/product/{aid}")
		public String deleteProduct(@PathVariable int aid)
		{
			Product a = repo.getById(aid);
			repo.delete(a);
			return "delted";
		}
		
		@PostMapping(path="/product", consumes = "application/json")
		public Product addProduct(Product product)
		{
			repo.save(product);
			return product;
		}
		
		@GetMapping(path="/products")
		
		public List<Product> getproduct()
		{
			return repo.findAll();
		}
		
		@RequestMapping("/products/{aid}")
		public Optional<Product> getProduct(@PathVariable("aid") int aid)
		{
			return repo.findById(aid);
		}
		
}

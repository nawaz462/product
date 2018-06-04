package com.makeanthon.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.makeanthon.product.Entity.FilterParams;
import com.makeanthon.product.service.ProductService;
import com.mongodb.DBObject;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;

	@RequestMapping(value="/products",method=RequestMethod.GET)
	public List<DBObject> getAllProducts(){
		
		return productService.getAllProducts();
	}
	
	@RequestMapping(value="/products/{productId}",method=RequestMethod.GET)
	public List<DBObject> getProductInfo(@PathVariable("productId") String productId){
		
		return productService.getProductDetails(productId);
	}
	
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public List<DBObject> getFilteredProducts(@RequestBody FilterParams filterParams){
		System.out.println("In Filter...");
		return productService.getFilteredProducts(filterParams);
	}
}

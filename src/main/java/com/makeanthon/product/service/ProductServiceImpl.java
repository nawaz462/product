package com.makeanthon.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.makeanthon.product.Dao.ProductDao;
import com.makeanthon.product.Entity.FilterParams;
import com.mongodb.DBObject;

@Component
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao productRepo;
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<DBObject> getAllProducts() {
		
		return mongoTemplate.findAll(DBObject.class, "product");
	}

	@Override
	public List<DBObject> getProductDetails(String productId) {
		System.out.println("In details...");
		return productRepo.getProductByName(productId);
	}

	@Override
	public List<DBObject> getFilteredProducts(FilterParams filterParams) {

		return productRepo.getFilteredProducts(filterParams);
	}

}

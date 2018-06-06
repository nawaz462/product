package com.makeanthon.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.makeanthon.product.Dao.ProductDao;
import com.makeanthon.product.Entity.FilterParams;
import com.mongodb.DBObject;

@Component
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao productRepo;

	@Override
	public List<DBObject> getAllProducts(int page) {
		
		return productRepo.getAllProdutsWithLimit(page);
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

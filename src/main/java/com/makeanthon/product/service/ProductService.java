package com.makeanthon.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.makeanthon.product.Entity.FilterParams;
import com.mongodb.DBObject;

@Service
public interface ProductService {

	List<DBObject> getAllProducts();

	List<DBObject> getProductDetails(String productId);

	List<DBObject> getFilteredProducts(FilterParams filterParams);

}

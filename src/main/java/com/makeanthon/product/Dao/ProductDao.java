package com.makeanthon.product.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.makeanthon.product.Entity.FilterParams;
import com.mongodb.DBObject;

@Repository
public interface ProductDao {

	List<DBObject> getProductByName(String productId);

	 List<DBObject> getFilteredProducts(FilterParams filterParams);

}
	

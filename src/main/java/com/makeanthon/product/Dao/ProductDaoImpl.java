package com.makeanthon.product.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.makeanthon.product.Entity.FilterParams;
import com.mongodb.DBObject;

@Component
public class ProductDaoImpl implements ProductDao{

	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public List<DBObject> getProductByName(String productId) {
		
		Criteria nameCriteria = Criteria.where("id").is(productId);
		return mongoTemplate.find(new Query(nameCriteria), DBObject.class, "product");
	}

	@SuppressWarnings("static-access")
	@Override
	public List<DBObject> getFilteredProducts(FilterParams filterParams) {

		Criteria filterSearchCriteria = new Criteria();
		
		if(filterParams.getBrand().size() > 0)
			filterSearchCriteria = filterSearchCriteria.where("brand").in(filterParams.getBrand());
		if(filterParams.getSize().size() > 0)
			filterSearchCriteria = filterSearchCriteria.where("size").in(filterParams.getSize());
		if(filterParams.getCategory().size() > 0)
			filterSearchCriteria = filterSearchCriteria.where("category").in(filterParams.getCategory());
		if(filterParams.getColor().size() > 0)
			filterSearchCriteria = filterSearchCriteria.where("color").in(filterParams.getColor());
		if(StringUtils.isEmpty(filterParams.getName()) )
			filterSearchCriteria = filterSearchCriteria.where("name").in(filterParams.getName());
		
		return mongoTemplate.find(new Query(filterSearchCriteria), DBObject.class, "product");
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<DBObject> getAllProdutsWithLimit(int page) {
		
		Query limitQuery = new Query();
		limitQuery.with(new PageRequest(page, 5, new Sort(Sort.Direction.ASC, "id")));
		return mongoTemplate.find(limitQuery, DBObject.class, "product");
	}

	
}

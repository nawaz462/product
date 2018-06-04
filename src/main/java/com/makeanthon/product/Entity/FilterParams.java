package com.makeanthon.product.Entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class FilterParams {
	
	Set<String> brand = new HashSet<>();
	 Set<String> category = new HashSet<>();
	 Set<String> size = new HashSet<>();
	 Set<String> color = new HashSet<>();
	
	
	public Set<String> getBrand() {
		return brand;
	}
	public void setBrand(Set<String> brand) {
		this.brand = brand;
	}
	public Set<String> getCategory() {
		return category;
	}
	public void setCategory(Set<String> category) {
		this.category = category;
	}
	public Set<String> getSize() {
		return size;
	}
	public void setSize(Set<String> size) {
		this.size = size;
	}
	public Set<String> getColor() {
		return color;
	}
	public void setColor(Set<String> color) {
		this.color = color;
	}

	public FilterParams() {
	}
}

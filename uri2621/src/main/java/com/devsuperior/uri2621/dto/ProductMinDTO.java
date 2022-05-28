package com.devsuperior.uri2621.dto;

import com.devsuperior.uri2621.projections.ProductMinProjetion;

public class ProductMinDTO {

	String name;

	public ProductMinDTO(String name) {
		this.name = name;
	}
	
	public ProductMinDTO(ProductMinProjetion pmp) {
		this.name = pmp.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductMinDTO [name=" + name + "]";
	}
	
	
	
}

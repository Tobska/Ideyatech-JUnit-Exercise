package com.ideyatech.ut.exercise;

import java.util.ArrayList;

public class ProductList {
	ArrayList<Product> products;
	
	public void addProduct(Product product){
		products.add(product);
	}
	
	public ArrayList<Product> getProduct(){
		return this.products;
	}
}

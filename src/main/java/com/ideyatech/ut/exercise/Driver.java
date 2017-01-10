package com.ideyatech.ut.exercise;

import java.util.ArrayList;

public class Driver {
	public static void main(String[] args){
		Product small = new Product("UNLI_1GB", "SMALL", 1000.00);
		Product medium = new Product("UNLI_2GB", "MEDIUM", 1500.00);
		Product large = new Product("UNLI_5GB", "LARGE", 3000.00);
		Product add = new Product("1GB_ADDTL", "1GB", 500.00);
		
		ArrayList<Product> list = new ArrayList<Product>();
		list.add(small);
		
		Promotionals promo1 = new Promotionals(small, 3, 2);
		
		ArrayList<Promotionals> promos = new ArrayList<Promotionals>();
		promos.add(promo1);
		
		ShoppingCart cart = new ShoppingCart();
		
		for (int i = 0; i < 5; i++)
			cart.addProduct(large);
		
		for (int i = 0; i < 3; i++)
			cart.addProduct(small);
		
		for (int i = 0; i < 2; i++)
			cart.addProduct(medium);
		
		
		for(int i = 0; i < promos.size(); i++){
			promos.get(i).check(cart);
		}
		
		cart.checkout();
	}
}

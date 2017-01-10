package com.ideyatech.ut.exercise;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class ShoppingCartTest {

	ShoppingCart shoppingCart = new ShoppingCart();

	Product small = new Product("UNLI_1GB", "SMALL", 1000.00);
	Product medium = new Product("UNLI_2GB", "MEDIUM", 1500.00);
	Product large = new Product("UNLI_5GB", "LARGE", 3000.00);
	Product add = new Product("1GB_ADDTL", "1GB", 500.00);
	
	
	
	public void checkNoPromo () {
		
	}
	
	@Test
	public void checkPromo1 () {
		
		Promotionals promo1 = new Promotionals(small, 3, 2);
		
		
		shoppingCart.addProduct(small);
		shoppingCart.addProduct(small);
		shoppingCart.addProduct(small);
		
		promo1.check(shoppingCart);
		shoppingCart.checkout();
		
		assertEquals(2000.00, shoppingCart.getTotal(), 0);
	}
	
	@Test
	public void testPromo2HasSmall () {
		
		Promotionals promo2 = new Promotionals(large, 5, small, 1);
		
		for (int i = 0; i < 5; i++)
			shoppingCart.addProduct(large);
		
		promo2.check(shoppingCart);
		shoppingCart.checkout();

		assertTrue(shoppingCart.hasProduct(small));
		
	}
	
	@Test
	public void testPromo3HasAddtl () {
		
		Promotionals promo3 = new Promotionals(medium, 1, add, 1);
		
		shoppingCart.addProduct(medium);
		
		promo3.check(shoppingCart);
		shoppingCart.checkout();
		
		assertTrue(shoppingCart.hasProduct(add));
	}
	
}

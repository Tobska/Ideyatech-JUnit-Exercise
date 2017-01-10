package com.ideyatech.ut.exercise;

import java.awt.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ShoppingCart {
	ArrayList<Product> cart;
	ArrayList<Product> bonus;
	
	public ShoppingCart(){
		this.cart = new ArrayList<Product>();
		this.bonus = new ArrayList<Product>();
	}
	
	public void addProduct(Product product){
		cart.add(product);
	}
	
	public void removeProduct(Product product){
		cart.remove(product);
	}
	
	public void addBonus(Product product){
		bonus.add(product);
	}
	
	public void removeBonus(Product product){
		bonus.remove(product);
	}
	
	public Object[][] displayBoughtCart(){
		ArrayList<String> products = new ArrayList<String>();
		ArrayList<Integer> display = new ArrayList<Integer>();
		
		for(int i = 0; i < cart.size(); i++){
			if(products.contains(cart.get(i).getProduct_id())){
				display.set(products.indexOf(cart.get(i).getProduct_id()), 
						    display.get(products.indexOf(cart.get(i).getProduct_id())) + 1);
			}else{
				products.add(cart.get(i).getProduct_id());
				display.add(1);
			}
		}
		
		Object[][] list = new Object[products.size()][2];
		
		for(int i = 0; i < list.length; i++){
			list[i][0] = products.get(i);
			list[i][1] = display.get(i);
		}
		return list;
	}
	
	public Object[][] displayBonusCart(){
		ArrayList<String> products = new ArrayList<String>();
		ArrayList<Integer> display = new ArrayList<Integer>();
		
		for(int i = 0; i < bonus.size(); i++){
			if(products.contains(bonus.get(i).getProduct_id())){
				System.out.println(products.indexOf(bonus.get(i).getProduct_id()));
				display.set(products.indexOf(bonus.get(i).getProduct_id()), 
						    display.get(products.indexOf(bonus.get(i).getProduct_id())) + 1);
			}else{
				products.add(bonus.get(i).getProduct_id());
				display.add(1);
			}
		}
		
		Object[][] list = new Object[products.size()][2];
		
		for(int i = 0; i < list.length; i++){
			list[i][0] = products.get(i);
			list[i][1] = display.get(i);
		}
		return list;
	}
	
	public double getTotal(){
		double price = 0;
		for(int i = 0; i < cart.size(); i++){
			price += cart.get(i).getPrice();
		}
		return price;
	}
	
	public ArrayList<Object[]> checkout(){
		
		Object[][] bought = displayBoughtCart();
		Object[][] bonus = displayBonusCart();
		ArrayList<Object[]> total = new ArrayList<Object[]>();
		for(int i = 0; i < bought.length; i++){
			Object[] item = new Object[2];
			item[0] = bought[i][0];
			item[1] = bought[i][1];
			total.add(item);
		}
		
		for(int i = 0; i < bonus.length; i++){
			System.out.println("I = " + i);
			int j, k;
			for(k = 0; k < total.size(); k++){
				if(total.get(k)[0].equals(bonus[i][0])){
					j = total.indexOf(bonus[i][0]);
					break;
				}
			}
			j = k;
			System.out.println("J IS " + j);
			if(j == total.size()){
				System.out.println("ADDING HERE");
				Object[] item = new Object[2];
				item[0] = bonus[i][0];
				item[1] = bonus[i][1];
				total.add(item);
			}else {
				System.out.println("IN HERE");
				Integer x = ((Integer) total.get(j)[1]) + ((Integer)bonus[i][1]);
				total.get(j)[1] = x;
			}
		}
		
		
		/*
		System.out.println("\nSTART");
		for(int i = 0; i < bought.length; i++){
			System.out.println(bought[i][0] + "\t\t" + bought[i][1]);
		}
		
		System.out.println("\nSTART");
		for(int i = 0; i < bonus.length; i++){
			System.out.println(bonus[i][0] + "\t\t" + bonus[i][1]);
		}
		*/
		System.out.println("\nSTART");
		for(int i = 0; i < total.size(); i++){
			System.out.println(total.get(i)[0] + "\t\t" + total.get(i)[1]);
		}
		System.out.println("TOTAL PRICE: " + getTotal());
		
		return total;
		
	}
	
	public int getSize(){
		return this.cart.size();
	}
	
	public Product getProduct(int index){
		return this.cart.get(index);
	}
	
	public boolean hasProduct(Product p){
	//public int countProducts(Product p){
		/*
		System.out.println("A: " + this.cart.contains(p));
		System.out.println("A: " + this.bonus.contains(p));
		
		return this.cart.contains(p) || this.bonus.contains(p);
		*/
		ArrayList<Object[]> myItems = checkout();
		for(int i = 0; i < myItems.size(); i++){
			if (myItems.get(i)[0].equals(p.getProduct_id()))
				return true;
			
		}
		
		return false;
	
	}
	
}

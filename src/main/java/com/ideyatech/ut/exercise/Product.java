package com.ideyatech.ut.exercise;

public class Product {
	private String product_id;
	private String name;
	private double price;

	public Product(String product_id, String name, double price){
		setProduct_id(product_id);
		setName(name);
		setPrice(price);
	}
	
	public String getProduct_id() {
		return product_id;
	}



	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public void showInfo(){
		System.out.println(product_id + "\t" + name + "\t" + price);
	}
}

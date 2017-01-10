package com.ideyatech.ut.exercise;

import java.util.ArrayList;

public class Promotionals {
	Product requiredProd;
	int requiredAmt;
	
	int bonusQty;
	ArrayList<Product> bonuses;
	
	public Promotionals(Product requiredProd, int requiredAmt, Product bonusProd, int bonusQty){
		this.requiredAmt = requiredAmt;
		this.requiredProd = requiredProd;
		this.bonuses = new ArrayList<Product>();
		this.bonusQty = bonusQty;
		for(int i = 0; i < bonusQty; i++){
			bonuses.add(bonusProd);
		}
	}
	
	public Promotionals(Product requiredProd, int requiredAmt, int newAmt){
		this.requiredAmt = requiredAmt;
		this.requiredProd = requiredProd;
		this.bonuses = null;
		this.bonusQty = newAmt;
	}

	public Promotionals(Product requiredProd, int requiredAmt, ArrayList<Product> bonuses){
		this.requiredAmt = requiredAmt;
		this.requiredProd = requiredProd;
		this.bonuses = new ArrayList<Product>();
		
		for(int i = 0; i < bonuses.size(); i++){
			this.bonuses.add(bonuses.get(i));
		}
		bonusQty = bonuses.size();
	}
	
	public void check(ShoppingCart cart){
		ArrayList<Integer> index = new ArrayList<Integer>();
		for(int i = 0; i < cart.getSize(); i++){
			if(cart.getProduct(i).getProduct_id().equals(requiredProd.getProduct_id())){
				index.add(i);
			}
		}
		
		if(index.size() >= requiredAmt){
			int times = index.size()/requiredAmt;
			for(int i = 0; i < times; i++){
				if(bonuses == null){
					int toModify = requiredAmt - bonusQty;
					System.out.println("WILL DO THIS " + toModify + " times");
					for(int j = 0; j < toModify; j++){
						cart.removeProduct(requiredProd);
						cart.addBonus(new Product(requiredProd.getProduct_id(),requiredProd.getName(), 0));
					}
				}else{
					for(int j = 0; j < bonuses.size(); j++){						
						cart.addBonus(new Product(bonuses.get(j).getProduct_id(),bonuses.get(j).getName(), 0));
					}
				}
			}
		}
	}

	public Product getRequiredProd() {
		return requiredProd;
	}

	public void setRequiredProd(Product requiredProd) {
		this.requiredProd = requiredProd;
	}

	public int getRequiredAmt() {
		return requiredAmt;
	}

	public void setRequiredAmt(int requiredAmt) {
		this.requiredAmt = requiredAmt;
	}
	
	
	
}

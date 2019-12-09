package com.face.bo;

public class ProductList {
	String productName;
    String productId ;
    String quantity;
    String price;
    
	public String getProductName() {
		//System.out.println("productName"+productName);
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;	
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
    
}

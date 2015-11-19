package com.example.uchumi;

public class Product {
  private String id,name,price,quantity,discount,expirydate;

public Product(String id, String name, String price, String quantity,
		String discount, String expirydate) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.quantity = quantity;
	this.discount = discount;
	this.expirydate = expirydate;
}

public String getId() {
	return id;
}

public String getName() {
	return name;
}

public String getPrice() {
	return price;
}

public String getQuantity() {
	return quantity;
}

public String getDiscount() {
	return discount;
}

public String getExpirydate() {
	return expirydate;
}
  
}

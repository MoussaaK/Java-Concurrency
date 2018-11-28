package org.konate.tp_concurrence_maven.serie2.exo3;

public class Product {
	private String name;
	private double price;
	private long id;
	public Product(String name, long id) {
		super();
		this.name = name;
		this.id = id;
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
	public long getId() {
		return id;
	}
}

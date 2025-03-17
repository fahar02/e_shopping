package com.eshoping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products {

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", brand=" + brand + ", category=" + category + ", amount="
				+ amount + ", discount=" + discount + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public Products() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String brand;
	private String category;
	private double amount;
	private double discount;
	public Products(int id, String name, String brand, String category, double amount, double discount) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.amount = amount;
		this.discount = discount;
	}
}

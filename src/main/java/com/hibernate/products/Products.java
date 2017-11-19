package com.hibernate.products;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Products {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;
	private int supplierid;
	private String categoryid;
	private String subcategoryid;
	private String productname;
	private String productprice;
	private String productimage;
	private String imagepublicid;
	private String productdescription;
	private String productquantity;
	private String productdiscount;
	private boolean active = true;

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getSupplierid() {
		return supplierid;
	}


	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}


	public String getCategoryid() {
		return categoryid;
	}


	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}


	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	public String getProductprice() {
		return productprice;
	}


	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}


	public String getProductimage() {
		return productimage;
	}


	public void setProductimage(String productimage) {
		this.productimage = productimage;
	}


	public String getImagepublicid() {
		return imagepublicid;
	}


	public void setImagepublicid(String imagepublicid) {
		this.imagepublicid = imagepublicid;
	}


	public String getProductdescription() {
		return productdescription;
	}


	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}


	public String getProductquantity() {
		return productquantity;
	}


	public void setProductquantity(String productquantity) {
		this.productquantity = productquantity;
	}


	public String getProductdiscount() {
		return productdiscount;
	}


	public void setProductdiscount(String productdiscount) {
		this.productdiscount = productdiscount;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}

	

	public String getSubcategoryid() {
		return subcategoryid;
	}


	public void setSubcategoryid(String subcategoryid) {
		this.subcategoryid = subcategoryid;
	}


	public Products() {
		
	}
	
}

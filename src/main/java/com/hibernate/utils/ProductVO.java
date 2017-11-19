package com.hibernate.utils;

public class ProductVO {
	private int id;
	private String categoryname;
	private String subcategoryid;
	private String categoryid;
	private String subname;	
	private String imagepublicid;
	private String productdescription;
	private String productdiscount;
	private String productimage;
	private String productname;
	private String productprice;
	private String productquantity;
	private int supplierid;
	private Boolean active;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public String getProductdescription() {
		return productdescription;
	}
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}
	public String getProductdiscount() {
		return productdiscount;
	}
	public void setProductdiscount(String productdiscount) {
		this.productdiscount = productdiscount;
	}
	public String getProductimage() {
		return productimage;
	}
	public void setProductimage(String productimage) {
		this.productimage = productimage;
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
	public String getProductquantity() {
		return productquantity;
	}
	public void setProductquantity(String productquantity) {
		this.productquantity = productquantity;
	}
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public ProductVO() {
		super();
	}
	public String getSubcategoryid() {
		return subcategoryid;
	}
	public void setSubcategoryid(String subcategoryid) {
		this.subcategoryid = subcategoryid;
	}
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	public String getImagepublicid() {
		return imagepublicid;
	}
	public void setImagepublicid(String imagepublicid) {
		this.imagepublicid = imagepublicid;
	}
	
	
}

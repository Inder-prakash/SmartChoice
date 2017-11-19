package com.hibernate.categories;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class Categories {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	private String categoryname;
	private String categorydescription;
	private String categoryimage;
	private String imagepublicid;
	
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
	public String getCategorydescription() {
		return categorydescription;
	}
	public void setCategorydescription(String categorydescription) {
		this.categorydescription = categorydescription;
	}
	public String getCategoryimage() {
		return categoryimage;
	}
	public void setCategoryimage(String categoryimage) {
		this.categoryimage = categoryimage;
	}
	public String getImagepublicid() {
		return imagepublicid;
	}
	public void setImagepublicid(String imagepublicid) {
		this.imagepublicid = imagepublicid;
	}
	public Categories() {
		super();
	}
	

}

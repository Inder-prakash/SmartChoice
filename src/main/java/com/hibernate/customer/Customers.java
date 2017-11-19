package com.hibernate.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "Customers")
public class Customers {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Pattern(regexp="^[a-zA-Z0-9\\.]{5,20}$",message="* Username Must contain 5 letters and 20 maximum")
	private String firstname;
	
	@Pattern(regexp="^[a-zA-Z0-9\\.]{5,20}$",message="* Username Must contain 5 letters and 20 maximum")
	private String lastname;
	
	@Pattern(regexp="^[a-zA-Z0-9\\.]{2,20}@[a-zA-Z]{2,20}\\.[a-zA-Z]{2,20}(\\.[a-zA-Z]{2,20}){0,1}$",message="* Invalid Email Address")
	private String email;
	
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}$" 
			, message="* Minimum eight characters, "
					+ "at least one uppercase letter,"
					+ " one lowercase letter, "
					+ "one number and one "
					+ "special character:")
	private String password;
	
	@Pattern(regexp="^[7-9]{1,1}[0-9]{9,9}$",message="* Invalid Phone Number")
	private String phone;	
	
	@NotEmpty(message="* Enter Address")
	private String address1;
	
	
	private String address2;
	
	
	private String city;
	
	@Pattern(regexp="^[1-9]{1,1}[0-9]{5,5}$",message="* Invalid Pin Code")
	private String pincode;
	
	private String wallet = "0";
	
	private String role = "ROLE_USER";
	
	private boolean active = true;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getWallet() {
		return wallet;
	}

	public void setWallet(String wallet) {
		this.wallet = wallet;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Customers() {
		super();
	}
	
	
}

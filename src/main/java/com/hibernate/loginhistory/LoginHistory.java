package com.hibernate.loginhistory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoginHistory {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="User_Name",nullable=false)
	private String username;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(name="login_status",nullable=false)
	private String status;
	
	@Column(name="login_time")
	private String logintime;
	
	@Column(name="logout_time")
	private String logouttime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLogintime() {
		return logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public String getLogouttime() {
		return logouttime;
	}

	public void setLogouttime(String logouttime) {
		this.logouttime = logouttime;
	}

	public LoginHistory() {
		
	}
	
	
	
	
	
}

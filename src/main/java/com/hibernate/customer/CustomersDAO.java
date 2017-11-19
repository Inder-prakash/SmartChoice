package com.hibernate.customer;

import java.util.List;

public interface CustomersDAO {
	void insert(Customers cust);
	void update(Customers cust);
	void delete(int id);
	void ublock(int id);
	void changeRole(int id,String wallet,String Role);
	Customers getCustomer(int id);
	Customers getSupplier(int id);
	Customers getAdmin(int id);
	Customers getSuppliers(String email);
	Customers getCustomer(String email);
	int getCustomerId(String email);
	boolean getEmails(String email);
	List<Customers> getAllUsers();
	List<Customers> getAllCustomers();
	List<Customers> getAllSuppliers();
	List<Customers> getAllAdmins();
	List<Customers> getAllBlockedCustomers();
	List<Customers> getAllBlockedSuppliers();
	List<Customers> getAllBlockedAdmins();
}

package com.hibernate.customer;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomersDAOImpl implements CustomersDAO {
	
	@Autowired 
	private SessionFactory sessionFactory;
	public void insert(Customers cust) {
		this.sessionFactory.getCurrentSession().save(cust);
	}

	public void update(Customers cust) {
		this.sessionFactory.getCurrentSession().update(cust);
	}

	public void delete(int id) {
		this.sessionFactory.getCurrentSession().createQuery( "UPDATE Customers SET active =0 WHERE id=:id " ).setInteger("id", id).executeUpdate();
	}

	public Customers getCustomer(int id) {
		return (Customers)this.sessionFactory.getCurrentSession().createQuery("from Customers where id=:id").setInteger("id",id).list().get(0);
	}
	
	public Customers getSupplier(int id) {
		return (Customers)this.sessionFactory.getCurrentSession().createQuery("from Customers where id=:id").setInteger("id",id).list().get(0);
	}
	
	public Customers getAdmin(int id) {
		return (Customers)this.sessionFactory.getCurrentSession().createQuery("from Customers where id=:id").setInteger("id",id).list().get(0);
	}
	
	public boolean getEmails(String email) {
		int num = ((Number) this.sessionFactory.getCurrentSession().createQuery("select count(*) from Customers where email=:email").setString("email", email).uniqueResult()).intValue();
		boolean flag = false;
		if(num > 0) {
			flag = true;
		}
		return flag;
	}

	public List<Customers> getAllCustomers() {
		return (List<Customers>)this.sessionFactory.getCurrentSession().createQuery("from Customers where role = 'ROLE_USER' and active = 1").list();
	}

	public List<Customers> getAllSuppliers() {
		return (List<Customers>)this.sessionFactory.getCurrentSession().createQuery("from Customers where role = 'ROLE_SUPPLIER' and active = 1").list();
	}

	public List<Customers> getAllAdmins() {
		return (List<Customers>)this.sessionFactory.getCurrentSession().createQuery("from Customers where role = 'ROLE_ADMIN' and active = 1").list();
	}

	public List<Customers> getAllBlockedCustomers() {
		return (List<Customers>)this.sessionFactory.getCurrentSession().createQuery("from Customers where role = 'ROLE_USER' and active = 0").list();
	}

	public List<Customers> getAllBlockedSuppliers() {
		return (List<Customers>)this.sessionFactory.getCurrentSession().createQuery("from Customers where role = 'ROLE_SUPPLIER' and active = 0").list();
	}

	public List<Customers> getAllBlockedAdmins() {
		return (List<Customers>)this.sessionFactory.getCurrentSession().createQuery("from Customers where role = 'ROLE_ADMIN' and active = 0").list();
	}

	public void ublock(int id) {
		this.sessionFactory.getCurrentSession().createQuery( "UPDATE Customers SET active =1 WHERE id=:id " ).setInteger("id", id).executeUpdate();
	}

	public void changeRole(int id,String wallet,String Role) {
		this.sessionFactory.getCurrentSession().createQuery( "UPDATE Customers SET role=:role, wallet=:wallet WHERE id=:id" ).setString("role", Role).setString("wallet", wallet).setInteger("id", id).executeUpdate();
	}

	public Customers getSuppliers(String email) {
		return (Customers)this.sessionFactory.getCurrentSession().createQuery("from Customers where email=:email").setString("email",email).list().get(0);
	}

	public Customers getCustomer(String email) {
		return (Customers)this.sessionFactory.getCurrentSession().createQuery("from Customers where email=:email").setString("email",email).list().get(0);
	}

	public int getCustomerId(String email) {
		int num = ((Number) this.sessionFactory.getCurrentSession().createQuery("select id from Customers where email=:email").setString("email", email).uniqueResult()).intValue();
		return num;
	}

	public List<Customers> getAllUsers() {
		return (List<Customers>)this.sessionFactory.getCurrentSession().createQuery("from Customers ").list();
	}


}

package com.hibernate.cart;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class CartDAOImpl implements CartDAO {

	@Autowired 
	private SessionFactory sessionFactory;
	public void insert(Cart c) {
		this.sessionFactory.getCurrentSession().save(c);		
	}

	public void update(Cart c) {
		this.sessionFactory.getCurrentSession().update(c);
	}

	public void update(int userid, String ship, String bill) {
		this.sessionFactory.getCurrentSession().createQuery("update Cart set shippingaddress = :ship, billingaddress= :bill where customerid=:userid").setString("ship", ship).setString("bill", bill).setInteger("userid", userid).executeUpdate();
	}

	public void delete(int id) {
		this.sessionFactory.getCurrentSession().createQuery("delete from Cart where id=:id").setInteger("id", id).executeUpdate();
	}

	public List<Cart> getAllCart() {
		return (List<Cart>)this.sessionFactory.getCurrentSession().createQuery("from Cart").list();	
	}

	public Cart getCartbyId(int id) {
		return (Cart)this.sessionFactory.getCurrentSession().createQuery("from Cart where customerid=:id").setInteger("id", id).list().get(0);	
	}

	public List<Cart> getProductsbycustid(int userid) {
		return (List<Cart>)this.sessionFactory.getCurrentSession().createQuery("from Cart where customerid=:id").setInteger("id", userid).list();
	}
	
}

package com.hibernate.categories;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.products.Products;
@Repository
@Transactional
public class CategoriesDAOImp implements CategoriesDAO {
	
	@Autowired 
	private SessionFactory sessionFactory;
	public void insert(Categories c) {
		this.sessionFactory.getCurrentSession().save(c);	
	}

	public void update(Categories c) {
		this.sessionFactory.getCurrentSession().update(c);
	}

	public void delete(int id) {
		this.sessionFactory.getCurrentSession().createQuery("delete from Categories where id=:id").setInteger("id", id).executeUpdate();
	}

	public Categories getCategories(int id) {
		return (Categories)this.sessionFactory.getCurrentSession().createQuery("from Categories where id=:id").setInteger("id", id).list().get(0);
	}

	public List<Categories> getAllCategories() {
		return (List<Categories>)this.sessionFactory.getCurrentSession().createQuery("from Categories").list();
	}

	public String getCatname(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}

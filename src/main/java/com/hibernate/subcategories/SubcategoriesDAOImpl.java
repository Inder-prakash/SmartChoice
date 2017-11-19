package com.hibernate.subcategories;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class SubcategoriesDAOImpl implements SubcategoriesDAO {
	@Autowired 
	private SessionFactory sessionFactory;
	public void insert(Subcategories sub) {
		this.sessionFactory.getCurrentSession().save(sub);
	}
	public void update(Subcategories sub) {

	}
	public void delete(int cid) {
	
	}
	public List<Subcategories> getASubcategories() {
		return (List<Subcategories>)this.sessionFactory.getCurrentSession().createQuery("from Subcategories").list();
	}
	public String getCatname() {
		return null;
	}
}

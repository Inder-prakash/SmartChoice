package com.hibernate.products;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LadtestproductDAOImpl implements LatestproductDAO {
	@Autowired 
	private SessionFactory sessionFactory;
	/*public List<Products> getLatestPhones() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid = 1 and active=1 order by id DESC").setMaxResults(4).list();
	}

	public List<Products> getLatestCamera() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid = 4 and active=1 order by id DESC ").setMaxResults(4).list();
	}

	public List<Products> getLatestLaptops() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid = 3 and active=1 order by id DESC ").setMaxResults(4).list();
	}

	public List<Products> getLatestGames() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid = 5 and active=1 order by id DESC ").setMaxResults(4).list();
	}

	public List<Products> getLatestTv() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid = 2 and active=1 order by id DESC ").setMaxResults(4).list();
	}

	public List<Products> getLatestMenShirts() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid = 6 and active=1 order by id DESC ").setMaxResults(4).list();
	}

	public List<Products> getLatestMenTShirts() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid = 7 and active=1 order by id DESC ").setMaxResults(4).list();
	}

	public List<Products> getLatestMenJeans() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid = 8 and active=1 order by id DESC ").setMaxResults(4).list();
	}

	public List<Products> getLatestMenWatches() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid = 10 and active=1 order by id DESC ").setMaxResults(4).list();
	}

	public List<Products> getLatestMenBoots() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid = 9 and active=1 order by id DESC ").setMaxResults(4).list();
	}

	public List<Products> getLatestWomenShirts() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid = 11 and active=1 order by id DESC ").setMaxResults(4).list();
	}

	public List<Products> getLatestWomenTShirts() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid = 13 and active=1 order by id DESC ").setMaxResults(4).list();
	}

	public List<Products> getLatestWomenJeans() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid = 12 and active=1 order by id DESC ").setMaxResults(4).list();
	}

	public List<Products> getLatestWomenWatches() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid = 15 and active=1 order by id DESC ").setMaxResults(4).list();
	}

	public List<Products> getLatestWomenBoots() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid = 14 and active=1 order by id DESC ").setMaxResults(4).list();
	}

	public List<Products> getLatestAcademic() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid = 20 and active=1 order by id DESC ").setMaxResults(4).list();
	}

	public List<Products> getLatestSciencefiction() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid = 21 and active=1 order by id DESC ").setMaxResults(4).list();
	}

	public List<Products> getLatestDrama() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid = 22 and active=1 order by id DESC ").setMaxResults(4).list();
	}

	public List<Products> getLatestComics() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid = 23 and active=1 order by id DESC ").setMaxResults(4).list();
	}*/

	public List<Products> getLatestProduct() {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where active=1 order by id DESC ").setMaxResults(4).list();
	}

}

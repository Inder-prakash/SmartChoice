package com.hibernate.loginhistory;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LoginHistoryDAOImpl implements LoginHistoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
				
	public void insert(LoginHistory lh) {
		this.sessionFactory.getCurrentSession().save(lh);
	}

	public List<LoginHistory> getAll() {
		return (List<LoginHistory>) this.sessionFactory.getCurrentSession().createQuery("from LoginHistory").list();
	}
}

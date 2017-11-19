package com.hibernate.categories;

import java.util.List;

public interface CategoriesDAO {
	void insert(Categories c);
	void update(Categories c);
	void delete(int cid);
	String getCatname(int id);
	Categories getCategories(int cid);
	List<Categories> getAllCategories();
}

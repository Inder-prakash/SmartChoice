package com.hibernate.subcategories;

import java.util.List;

public interface SubcategoriesDAO {
	void insert(Subcategories sub);
	void update(Subcategories sub);
	void delete(int cid);
	String getCatname();
	List<Subcategories> getASubcategories();
}

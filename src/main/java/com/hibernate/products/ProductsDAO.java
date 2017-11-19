package com.hibernate.products;

import java.util.List;

import com.hibernate.utils.ProductVO;

public interface ProductsDAO {
	void insert(Products p);
	void update(Products p);
	void delete(int pid);
	List<Products> getSupplierProducts(int id);
	List<Products> getSupplierBlockedProducts(int id);
	void ublock(int id);
	ProductVO getProduct(int pid);
	List<ProductVO> getAllBlockedProducts();
	List<ProductVO> getAllProducts();
	List<Products> getSelectedProducts(int catid);
	List<Products> getSearchdata(String keytag);
	List<Products> getbysubcat(int subid);
	
	Products getProductsbyId(int id);
}

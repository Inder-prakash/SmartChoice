package com.hibernate.products;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.categories.Categories;
import com.hibernate.products.Products;
import com.hibernate.utils.ProductVO;

@Repository
@Transactional
public class ProductsDAOImp implements ProductsDAO {

	@Autowired 
	private SessionFactory sessionFactory;
	public void insert(Products p) {
		this.sessionFactory.getCurrentSession().save(p);
	}

	public void update(Products p) {
		this.sessionFactory.getCurrentSession().update(p);
	}

	public void delete(int id) {
		this.sessionFactory.getCurrentSession().createQuery( "UPDATE Products SET active='0' WHERE id=:id" ).setInteger("id", id).executeUpdate();
	}

	public ProductVO getProduct(int id) {
		return (ProductVO)this.sessionFactory.getCurrentSession().createSQLQuery
				("Select distinct"
						+ " products.id,"
						+ "products.imagepublicid,"
						+ "products.subcategoryid, "
						+ "products.categoryid,"
						+ "categoryname, "
						+ "subname,"
						+ "productdescription, "
						+ "productdiscount, "
						+ "productimage,"
						+ " productname,"
						+ " productprice,"
						+ " productquantity, "
						+ "supplierid, "
						+ "active "
						+ "FROM subcategories join products on "
						+ "subcategories.id = products.subcategoryid "
						+ "LEFT OUTER JOIN categories ON  "
						+ "products.categoryid = categories.id "
						+ "where products.id =:id")
						.setInteger("id", id).setResultTransformer( Transformers.aliasToBean(ProductVO.class)).list().get(0);
	}

	public List<ProductVO> getAllProducts() {
		return (List<ProductVO>)this.sessionFactory.getCurrentSession().createSQLQuery
				("Select distinct"
						+ " products.id, "
						+ "categoryname, "
						+ "subname,"
						+ "productdescription, "
						+ "productdiscount, "
						+ "productimage,"
						+ " productname,"
						+ " productprice,"
						+ " productquantity, "
						+ "supplierid, "
						+ "active "
						+ "FROM subcategories join products on "
						+ "subcategories.id = products.subcategoryid "
						+ "LEFT OUTER JOIN categories ON  "
						+ "products.categoryid = categories.id "
						+ "where active=1")
				.setResultTransformer( Transformers.aliasToBean(ProductVO.class)).list();
	}

	public void ublock(int id) {
		this.sessionFactory.getCurrentSession().createQuery( "UPDATE Products SET active='1' WHERE id=:id" ).setInteger("id", id).executeUpdate();
	}

	public List<ProductVO> getAllBlockedProducts() {
		return (List<ProductVO>)this.sessionFactory.getCurrentSession().createSQLQuery
				("Select distinct"
						+ " products.id, "
						+ "categoryname, "
						+ "subname,"
						+ "productdescription, "
						+ "productdiscount, "
						+ "productimage,"
						+ " productname,"
						+ " productprice,"
						+ " productquantity, "
						+ "supplierid, "
						+ "active "
						+ "FROM subcategories join products on "
						+ "subcategories.id = products.subcategoryid "
						+ "LEFT OUTER JOIN categories ON  "
						+ "products.categoryid = categories.id "
						+ "where active=0")
				.setResultTransformer( Transformers.aliasToBean(ProductVO.class)).list();
	}

	public List<Products> getSupplierProducts(int id) {
		return (List<Products>)this.sessionFactory.getCurrentSession().createSQLQuery
				("Select distinct"
						+ " products.id, "
						+ "categoryname, "
						+ "subname,"
						+ "productdescription, "
						+ "productdiscount, "
						+ "productimage,"
						+ " productname,"
						+ " productprice,"
						+ " productquantity, "
						+ "supplierid, "
						+ "active "
						+ "FROM subcategories join products on "
						+ "subcategories.id = products.subcategoryid "
						+ "LEFT OUTER JOIN categories ON  "
						+ "products.categoryid = categories.id "
						+ "where supplierid=:id and active=1").setResultTransformer( Transformers.aliasToBean(ProductVO.class)).setInteger("id", id).list();
	}

	public List<Products> getSupplierBlockedProducts(int id) {
		return (List<Products>)this.sessionFactory.getCurrentSession().createSQLQuery
				("Select distinct"
						+ " products.id, "
						+ "categoryname, "
						+ "subname,"
						+ "productdescription, "
						+ "productdiscount, "
						+ "productimage,"
						+ " productname,"
						+ " productprice,"
						+ " productquantity, "
						+ "supplierid, "
						+ "active "
						+ "FROM subcategories join products on "
						+ "subcategories.id = products.subcategoryid "
						+ "LEFT OUTER JOIN categories ON  "
						+ "products.categoryid = categories.id "
						+ "where supplierid=:id and active=0").setResultTransformer( Transformers.aliasToBean(ProductVO.class)).setInteger("id", id).list();
	}

	public List<Products> getSelectedProducts(int catid) {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where categoryid =:catid and active=1").setInteger("catid", catid).list();
	}

	public List<Products> getSearchdata(String keytag) {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products p where p.productname like :keytag").setString("keytag", "%"+keytag+"%").list();
	}
	
	public List<Products> getbysubcat(int subid) {
		return (List<Products>)this.sessionFactory.getCurrentSession().createQuery("from Products where subcategoryid =:subid and active=1").setInteger("subid", subid).list();
	}

	public Products getProductsbyId(int id) {
		return (Products)this.sessionFactory.getCurrentSession().createQuery("from Products where id=:id").setInteger("id", id).list().get(0);
	}
}

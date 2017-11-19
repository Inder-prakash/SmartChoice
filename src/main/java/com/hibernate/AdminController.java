package com.hibernate;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hibernate.categories.Categories;
import com.hibernate.categories.CategoriesDAO;
import com.hibernate.customer.Customers;
import com.hibernate.customer.CustomersDAO;
import com.hibernate.loginhistory.LoginHistoryDAO;
import com.hibernate.products.ProductsDAO;
import com.hibernate.subcategories.Subcategories;
import com.hibernate.subcategories.SubcategoriesDAO;
import com.hibernate.utils.ProductVO;

@Controller
public class AdminController {
	@Autowired
	CategoriesDAO cdao;
	@Autowired
	ProductsDAO pdao;
	@Autowired
	CustomersDAO custdao;
	@Autowired
	LoginHistoryDAO lhdao;
	@Autowired
	SubcategoriesDAO subdao;
	
	@RequestMapping("/Admin")
	public ModelAndView admin() {
		return new ModelAndView("AdminPages/index");
	}
	
//	====================ADD TO DATABASE=========================
	
	@RequestMapping("/AddCategory")
	public ModelAndView AddCategory() {
		ModelAndView mv = new ModelAndView("AdminPages/AddCategory");
		mv.addObject("Category",new Categories());
		return mv;
	}
	

	@RequestMapping("/AddSubCategory")
	public ModelAndView AddSubCategory() {
		ModelAndView mv = new ModelAndView("AdminPages/AddSubCategory");
		mv.addObject("SubCategory",new Subcategories());
		mv.addObject("categoriesdata", cdao.getAllCategories());
		return mv;
	}
	
	@RequestMapping(value="/AddSubCategoryToDb",method=RequestMethod.POST)
	public ModelAndView AddSubCategoryToDb(@ModelAttribute("Subcategories") Subcategories sub, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/AddSubCategory");
		this.subdao.insert(sub);
		return mv;
	}
	
	@RequestMapping(value="/AddCategoryToDb",method=RequestMethod.POST)
	public ModelAndView AddCategoryToDb(HttpServletRequest req ,@RequestParam("file") MultipartFile file , @Valid @ModelAttribute("Category") Categories c, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/AddCategory");
		try {
			String path = req.getRealPath("/");
			MultipartFile img = file;
			byte b[] = new byte[img.getInputStream().available()];
			img.getInputStream().read(b);
			FileOutputStream fos = new FileOutputStream(path+"image.jpg");
			fos.write(b);
			fos.close();
			Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
	                  "cloud_name", "dljfin4o8",
	                  "api_key", "935574825223414",
	                  "api_secret", "4PRw27pYU8NRkVVUmpECm1L6hTk"));
			File f = new File(path+"image.jpg");
			Map uploadResult = cloudinary.uploader().upload(f,ObjectUtils.emptyMap());
			c.setCategoryimage(uploadResult.get("secure_url").toString());
			c.setImagepublicid(uploadResult.get("public_id").toString());
			this.cdao.insert(c);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}
	
//	====================View All From Database =========================
	
	@RequestMapping("/ViewProducts")
	public ModelAndView ViewProduct() {
		ModelAndView mv = new ModelAndView("AdminPages/ViewProducts");	
		mv.addObject("productdata", pdao.getAllProducts());
		return mv;
	}
	
	@RequestMapping("/ViewBlockedProducts")
	public ModelAndView ViewBlockedProduct() {
		ModelAndView mv = new ModelAndView("AdminPages/ViewBlockedProducts");	
		mv.addObject("productdata", pdao.getAllBlockedProducts());
		return mv;
	}
	
	
	@RequestMapping("/ViewBlockedCustomers")
	public ModelAndView ViewBlockedProfiles() {
		ModelAndView mv = new ModelAndView("AdminPages/ViewBlockedCustomers");
		mv.addObject("Customersdata",custdao.getAllBlockedCustomers());
		return mv;
	}
	
	@RequestMapping("/ViewBlockedAdmins")
	public ModelAndView ViewBlockedAdmins() {
		ModelAndView mv = new ModelAndView("AdminPages/ViewBlockedAdmins");
		mv.addObject("Adminsdata",custdao.getAllBlockedAdmins());
		return mv;
	}
	
	@RequestMapping("/ViewBlockedSuppliers")
	public ModelAndView ViewBlockedSuppliers() {
		ModelAndView mv = new ModelAndView("AdminPages/ViewBlockedSuppliers");
		mv.addObject("Suppliersdata",custdao.getAllBlockedSuppliers());
		return mv;
	}
	
	
	@RequestMapping("/ViewCustomers")
	public ModelAndView ViewProfiles() {
		ModelAndView mv = new ModelAndView("AdminPages/ViewCustomers");
		mv.addObject("Customersdata",custdao.getAllCustomers());
		return mv;
	}
	
	@RequestMapping("/ViewAdmins")
	public ModelAndView ViewAdmins() {
		ModelAndView mv = new ModelAndView("AdminPages/ViewAdmins");
		mv.addObject("Adminsdata",custdao.getAllAdmins());
		return mv;
	}
	
	@RequestMapping("/ViewSuppliers")
	public ModelAndView ViewSuppliers() {
		ModelAndView mv = new ModelAndView("AdminPages/ViewSuppliers");
		mv.addObject("Suppliersdata",custdao.getAllSuppliers());
		return mv;
	}
	
	@RequestMapping("/ViewCategories")
	public ModelAndView ViewCategory() {
		ModelAndView mv = new ModelAndView("AdminPages/ViewCategories");	
		mv.addObject("categoriesdata", cdao.getAllCategories());
		return mv;
	}
	
	@RequestMapping("/ViewLoginHistory")
	public ModelAndView ViewLoginHistory() {
		ModelAndView mv = new ModelAndView("AdminPages/ViewLoginHistory");
		mv.addObject("logindata",lhdao.getAll());
		return mv;
	}
//	====================View One Row From Database =========================
	
	@RequestMapping("/ViewOneCategory/{id}")
	public ModelAndView ViewOneCategory(@PathVariable("id")int id)
	{
		ModelAndView mv = new ModelAndView("AdminPages/ViewOneCategory");
		
		mv.addObject("categoriesdata",cdao.getCategories(id));
		
		return mv;
	}
	
	
	@RequestMapping("/ViewOneProduct/{id}")
	public ModelAndView ViewOneProduct(@PathVariable("id")int abc)
	{
		ModelAndView mv = new ModelAndView("AdminPages/ViewOneProduct");
		
		mv.addObject("productdata",pdao.getProduct(abc));
		
		return mv;
	}
	
	@RequestMapping("/ViewOneCustomer/{id}")
	public ModelAndView ViewOneProfile(@PathVariable("id")int id)
	{
		ModelAndView mv = new ModelAndView("AdminPages/ViewOneCustomer");		
		mv.addObject("Customerdata",custdao.getCustomer(id));	
		return mv;
	}
	
	@RequestMapping("/ViewOneAdmin/{id}")
	public ModelAndView ViewOneAdmin(@PathVariable("id")int id)
	{
		ModelAndView mv = new ModelAndView("AdminPages/ViewOneAdmin");		
		mv.addObject("Admindata",custdao.getAdmin(id));	
		return mv;
	}
	
	@RequestMapping("/ViewOneSupplier/{id}")
	public ModelAndView ViewOneSupplier(@PathVariable("id")int id)
	{
		ModelAndView mv = new ModelAndView("AdminPages/ViewOneSupplier");		
		mv.addObject("Supplierdata",custdao.getSupplier(id));	
		return mv;
	}
	
//	====================Delete One Row From Database =========================
	
	
	@RequestMapping("/DeleteOneProduct/{id}")
	public ModelAndView DeleteOneProduct(@PathVariable("id")int abc)
	{
		ModelAndView mv = new ModelAndView("redirect:/ViewProducts");	
		pdao.delete(abc);	
		return mv;
	}
	
	@RequestMapping("/UnblockOneProduct/{id}")
	public ModelAndView UnblockOneProduct(@PathVariable("id")int abc)
	{
		ModelAndView mv = new ModelAndView("redirect:/ViewBlockedProducts");	
		pdao.ublock(abc);	
		return mv;
	}
	
	
	@RequestMapping("/UnblockOneCustomer/{id}")
	public ModelAndView UnblockOneCustomer(@PathVariable("id")int id)
	{
		ModelAndView mv = new ModelAndView("redirect:/ViewBlockedCustomers");	
		custdao.ublock(id);	
		return mv;
	}
	
	@RequestMapping("/UnblockOneAdmin/{id}")
	public ModelAndView Unblock(@PathVariable("id")int id)
	{
		ModelAndView mv = new ModelAndView("redirect:/ViewBlockedAdmins");	
		custdao.ublock(id);
		return mv;
	}
	
	@RequestMapping("/UnblockOneSupplier/{id}")
	public ModelAndView UnblockOneSupplier(@PathVariable("id")int id)
	{
		ModelAndView mv = new ModelAndView("redirect:/ViewBlockedSuppliers");	
		custdao.ublock(id);
		return mv;
	}
	
	@RequestMapping("/DeleteOneCustomer/{id}")
	public ModelAndView DeleteOneCustomer(@PathVariable("id")int id)
	{
		ModelAndView mv = new ModelAndView("redirect:/ViewCustomers");	
		custdao.delete(id);	
		return mv;
	}
	
	@RequestMapping("/DeleteOneAdmin/{id}")
	public ModelAndView DeleteOneAdmin(@PathVariable("id")int id)
	{
		ModelAndView mv = new ModelAndView("redirect:/ViewAdmins");	
		custdao.delete(id);
		return mv;
	}
	
	@RequestMapping("/DeleteOneSupplier/{id}")
	public ModelAndView DeleteOneSupplier(@PathVariable("id")int id)
	{
		ModelAndView mv = new ModelAndView("redirect:/ViewSuppliers");	
		custdao.delete(id);
		return mv;
	}
	
	@RequestMapping("/DeleteOneCategory/{id}")
	public ModelAndView DeleteOneCategory(@PathVariable("id")int abc)
	{
		ModelAndView mv = new ModelAndView("redirect:/ViewCategories");	
		cdao.delete(abc);		
		return mv;
	}
	
//	====================Delete Multiple Row From Database =========================
	
	
	@RequestMapping("/delcustomers") 
	public ModelAndView delcustomers(HttpServletRequest req ) {
		String params[] = req.getParameterValues("SelectedId");
		ModelAndView mv = new ModelAndView("redirect:/ViewCustomers");
		for(String p:params) 
		{
			this.custdao.delete(Integer.parseInt(p));
		}
		return mv;
	}
	

	@RequestMapping("/deladmins") 
	public ModelAndView deladmins(HttpServletRequest req ) {
		String params[] = req.getParameterValues("SelectedId");
		ModelAndView mv = new ModelAndView("redirect:/ViewAdmins");
		for(String p:params) 
		{
			this.custdao.delete(Integer.parseInt(p));
		}
		return mv;
	}
	
	

	@RequestMapping("/delsuppliers") 
	public ModelAndView delsuppliers(HttpServletRequest req ) {
		String params[] = req.getParameterValues("SelectedId");
		ModelAndView mv = new ModelAndView("redirect:/ViewSuppliers");
		for(String p:params) 
		{
			this.custdao.delete(Integer.parseInt(p));
		}
		return mv;
	}
	
	@RequestMapping("/delProducts") 
	public ModelAndView delProducts(HttpServletRequest req ) {
		String params[] = req.getParameterValues("SelectedId");
		ModelAndView mv = new ModelAndView("redirect:/ViewProducts");
		for(String p:params) 
		{
			this.pdao.delete(Integer.parseInt(p));
		}
		return mv;
	}
	
	@RequestMapping("/deletcategories") 
	public ModelAndView deletcategories(HttpServletRequest req ) {
		String params[] = req.getParameterValues("SelectedId");
		ModelAndView mv = new ModelAndView("redirect:/ViewCategories");
		for(String p:params) 
		{
			this.cdao.delete(Integer.parseInt(p));
		}
		return mv;
	}
	
//	====================Update Data Into Database =========================	
	
	
	@RequestMapping("/changeRole")
	public ModelAndView changeRole(HttpServletRequest req)
	{
		int id = Integer.parseInt( req.getParameter("id") );
		String wallet = req.getParameter("wallet");
		String Role = req.getParameter("role");
		ModelAndView mv = new ModelAndView("redirect:/ViewOneCustomer/"+id);	
		this.custdao.changeRole(id,wallet,Role);
		return mv;
	}
	
	@RequestMapping("/UpdateAdminProfile/{id}")
	public ModelAndView UpdateAdminProfile(@PathVariable("id")int abc)
	{
		ModelAndView mv = new ModelAndView("AdminPages/UpdateAdminProfile");	
		//mv.addObject("profiledata",udao.getProfiles(abc));
		return mv;
	}
	
	@RequestMapping(value="/UpdateAdminToDB",method=RequestMethod.POST)
	public ModelAndView UpdateAdminToDB( HttpServletRequest req , @Valid @ModelAttribute("profiledata") Customers p , BindingResult resultset ) 
	{
		ModelAndView mv = new ModelAndView("redirect:/ViewProfiles");	
		//this.udao.update(p);
		return mv;
	}
	
	@RequestMapping("/UpdateOneCategory/{id}")
	public ModelAndView UpdateOneCategory(@PathVariable("id")int abc)
	{
		ModelAndView mv = new ModelAndView("AdminPages/UpdateCategory");
		mv.addObject("categoriesdata",cdao.getCategories(abc));
		return mv;
	}
	
	@RequestMapping(value="/UpdateCategoryToDB",method=RequestMethod.POST)
	public ModelAndView UpdateCategoryToDB( HttpServletRequest req ,@RequestParam("file") MultipartFile file, @Valid @ModelAttribute("categoriesdata") Categories c , BindingResult resultset )
	{
		ModelAndView mv = new ModelAndView("redirect:/ViewCategories");		
		try {
			if(!file.isEmpty()) {
				String path = req.getRealPath("/");
				MultipartFile img = file;
				byte b[] = new byte[img.getInputStream().available()];
				img.getInputStream().read(b);
				FileOutputStream fos = new FileOutputStream(path+"image.jpg");
				fos.write(b);
				fos.close();
				Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
		                  "cloud_name", "dljfin4o8",
		                  "api_key", "935574825223414",
		                  "api_secret", "4PRw27pYU8NRkVVUmpECm1L6hTk"));
				File f = new File(path+"image.jpg");
				
				if(!req.getParameter("pid").isEmpty()) {
					cloudinary.uploader().destroy(req.getParameter("pid"),
						    ObjectUtils.emptyMap());
				}
				
				Map uploadResult = cloudinary.uploader().upload(f,ObjectUtils.emptyMap());
				
				c.setCategoryimage(uploadResult.get("secure_url").toString());
				c.setImagepublicid(uploadResult.get("public_id").toString());
				this.cdao.update(c);	
			}
			else {
				c.setCategoryimage(req.getParameter("url"));
				c.setImagepublicid(req.getParameter("pid"));
				this.cdao.update(c);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return mv;
	}
		
}

package com.hibernate;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
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
import com.hibernate.categories.CategoriesDAO;
import com.hibernate.customer.CustomersDAO;
import com.hibernate.products.Products;
import com.hibernate.products.ProductsDAO;
import com.hibernate.subcategories.SubcategoriesDAO;


@Controller
public class SupplierController {
	@Autowired
	CustomersDAO custdao;
	@Autowired
	ProductsDAO pdao;
	@Autowired
	CategoriesDAO cdao;
	@Autowired
	SubcategoriesDAO subdao;

	@RequestMapping("/Supplier")
	public ModelAndView admin(Principal p) {

		ModelAndView mv = new ModelAndView("SupplierPages/index"); 
        mv.addObject("supplierdata",custdao.getSuppliers(p.getName()));	   	
		return mv;
	}
	
	@RequestMapping("/AddProduct")
	public ModelAndView AddProduct(Principal p) {
		ModelAndView mv = new ModelAndView("SupplierPages/AddProduct");	
		mv.addObject("Product", new Products());
		mv.addObject("supplierdata",custdao.getSuppliers(p.getName()));	
		mv.addObject("categoriesdata", cdao.getAllCategories());
		mv.addObject("subcategoriesdata", subdao.getASubcategories());
		return mv;
	}
	
	@RequestMapping(value="/AddProductToDb",method=RequestMethod.POST)
	public ModelAndView AddProductToDb(HttpServletRequest req , @RequestParam("file") MultipartFile file, @Valid @ModelAttribute("Product") Products p, BindingResult result) {
		
		ModelAndView mv =  new ModelAndView("redirect:/AddProduct");
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
			p.setProductimage(uploadResult.get("secure_url").toString());
			p.setImagepublicid(uploadResult.get("public_id").toString());
			this.pdao.insert(p);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("/ViewSupplierProducts/{id}")
	public ModelAndView ViewSupplierProducts(Principal p, @PathVariable("id")int id) {
		ModelAndView mv = new ModelAndView("SupplierPages/ViewSupplierProducts");	
		mv.addObject("supplierdata",custdao.getSuppliers(p.getName()));	
		mv.addObject("productdata", pdao.getSupplierProducts(id));
		return mv;
	}
	
	@RequestMapping("/BlockedSupplierProducts/{id}")
	public ModelAndView BlockedSupplierProducts(Principal p, @PathVariable("id")int id) {
		ModelAndView mv = new ModelAndView("SupplierPages/BlockedSupplierProducts");	
		mv.addObject("supplierdata",custdao.getSuppliers(p.getName()));	
		mv.addObject("productdata", pdao.getSupplierBlockedProducts(id));
		return mv;
	}
	
	
	@RequestMapping("/UpdateOneProduct/{id}")
	public ModelAndView UpdateOneProduct(@PathVariable("id")int abc , Principal p)
	{
		ModelAndView mv = new ModelAndView("SupplierPages/UpdateProduct");	
		mv.addObject("Product", pdao.getProduct(abc));
		mv.addObject("supplierdata",custdao.getSuppliers(p.getName()));	
		mv.addObject("categoriesdata", cdao.getAllCategories());
		mv.addObject("subcategoriesdata", subdao.getASubcategories());
		return mv;
	}
	
	
	@RequestMapping(value="/UpdateProductToDB",method=RequestMethod.POST)
	public ModelAndView UpdateProductToDB( HttpServletRequest req,  @RequestParam("file") MultipartFile file, @Valid @ModelAttribute("productdata") Products p , BindingResult resultset )
	{
		ModelAndView mv = new ModelAndView("redirect:/ViewSupplierProducts/"+req.getParameter("supplierid"));	
		try {
			if(!file.isEmpty()){
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
				p.setProductimage(uploadResult.get("secure_url").toString());
				p.setImagepublicid(uploadResult.get("public_id").toString());
				this.pdao.update(p);
			}
			else {
				System.out.println("dsfdsf");
				p.setProductimage(req.getParameter("url"));
				p.setImagepublicid(req.getParameter("pid"));
				this.pdao.update(p);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
}

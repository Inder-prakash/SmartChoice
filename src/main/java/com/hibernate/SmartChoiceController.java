package com.hibernate;

import java.io.IOException;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hibernate.cart.Cart;
import com.hibernate.cart.CartDAO;
import com.hibernate.categories.CategoriesDAO;
import com.hibernate.customer.Customers;
import com.hibernate.customer.CustomersDAO;
import com.hibernate.products.LatestproductDAO;
import com.hibernate.products.Products;
import com.hibernate.products.ProductsDAO;

@Controller
public class SmartChoiceController {
	@Autowired
	CustomersDAO custdao;
	@Autowired
	ProductsDAO pdao;
	@Autowired
	CategoriesDAO cdao;
	@Autowired
	LatestproductDAO ldao;
	@Autowired
	CartDAO cartdao;
	
	
	public String LoginTest()
	{
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null && !auth.getName().equals("anonymousUser"))
	    {    
	    	return "true";
	    }	
		return "false";
	}

	@RequestMapping("/")
	public ModelAndView landingpage() {
        ModelAndView mv = new ModelAndView("redirect:/index");
		return mv;
	}
	
	@RequestMapping("/index")
	public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");       
        mv.addObject("category",cdao.getAllCategories());
        mv.addObject("latestproduct",ldao.getLatestProduct());
		return mv;
	}
	
	@RequestMapping(value="/loginpage")
	public ModelAndView login() throws IOException{	
		ModelAndView mv = new ModelAndView("login");	
		return mv ;
	}
	
	@RequestMapping(value="/product")
	public ModelAndView product() throws IOException{	
		ModelAndView mv = new ModelAndView("product");	
		return mv ;
	}
	
	
	@RequestMapping("/SignUP")
	public ModelAndView SignUp() {
		ModelAndView mv = new ModelAndView("SignUp");
		mv.addObject("Customers", new Customers());
		return mv;
	}
	
	@RequestMapping(value="/AddCustomerToDb",method=RequestMethod.POST)
	public ModelAndView AddCustomerToDb( HttpServletRequest req , @Valid @ModelAttribute("Customers") Customers cust,BindingResult result ) {
		ModelAndView mv = new ModelAndView("redirect:/SignUP");
		String error = "";
		if(result.hasErrors()) {
			mv = new ModelAndView("SignUp");
			mv.addObject("Customers", cust);
			return mv;
			
		}	
		if (custdao.getEmails(req.getParameter("email"))){
			mv = new ModelAndView("SignUp");
			mv.addObject("Customers", cust);
			error = "Email address already exists.";
			mv.addObject("Emailmatch", error);
			return mv;
		}

		else {
			this.custdao.insert(cust);
			return mv;
		}
		
	}
	
	@RequestMapping("/UpdateProfile/{id}")
	public ModelAndView UpdateProfile(@PathVariable("id")int id) {
		ModelAndView mv = new ModelAndView("UpdateProfile");
		mv.addObject("Customers", custdao.getCustomer(id));
		return mv;
	}
	

	@RequestMapping(value="/UpdateProfileToDB",method=RequestMethod.POST)
	public ModelAndView UpdateProfileToDB( HttpServletRequest req , @Valid @ModelAttribute("profiledata") Customers cust , BindingResult resultset ) 
	{
		ModelAndView mv = new ModelAndView("redirect:/MyProfiles/"+req.getParameter("id"));	
		this.custdao.update(cust);
		return mv;
	}
	
	@RequestMapping("/MyProfiles/{id}")
	public ModelAndView MyProfiles(@PathVariable("id")int id) {
		ModelAndView mv = new ModelAndView("MyProfiles");
		mv.addObject("Customers", custdao.getCustomer(id));
		return mv;
	}
	
	@RequestMapping("/ViewProduct/{id}")
	public ModelAndView ViewProduct(@PathVariable("id")int catid) {
		ModelAndView mv = new ModelAndView("ViewProduct");	
		mv.addObject("productdata", pdao.getSelectedProducts(catid));
		return mv;
	}
	
	@RequestMapping("/productbysubcat/{id}")
	public ModelAndView productbysubcat(@PathVariable("id")int subid) {
		ModelAndView mv = new ModelAndView("ViewProduct");	
		mv.addObject("productdata", pdao.getbysubcat(subid));
		return mv;
	}
	
	@RequestMapping("/product/{id}")
	public ModelAndView product( @PathVariable("id")int catid , Principal p , HttpSession session) {
		ModelAndView mv = new ModelAndView("product");	
		if ( session.getAttribute("userName") != null ) {
			mv.addObject("user",custdao.getCustomer( p.getName().toString() ) );
		}
		mv.addObject("productdata", pdao.getProduct(catid));
		return mv;
	}
	
	@RequestMapping(value="/Searchdata",method=RequestMethod.POST)
	public ModelAndView Searchdata(@RequestParam("keytag") String keytag) {
		ModelAndView mv = new ModelAndView("searchresult");	
		mv.addObject("Searchdata", pdao.getSearchdata(keytag));
		return mv;
	}
	
	@RequestMapping(value="/AddCartToDB",method=RequestMethod.POST)
	public ModelAndView AddCartToDB( @RequestParam("address")String address , @RequestParam("quantity") int quantity ,@RequestParam("id")int id , @RequestParam("userid")int userid ) {
		
		
		ModelAndView mv = new ModelAndView("redirect:/cart");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && !auth.getName().equals("anonymousUser")) {
			boolean found = false;
			int i = -1;
			for( Cart c1 : cartdao.getProductsbycustid(userid) )
			{
				if( c1.getCustomerid() == userid && c1.getProductid()==id  )
				{
					found = true;
					i = c1.getId();
					break;
			    					
				}
				
			}
			if( found )
			{
				Cart c = cartdao.getCartbyId(i);
				
	            c.setQuantity(quantity);
				this.cartdao.update(c);
				return mv;

			}
			
			Cart c = new Cart();
			
			c.setCustomerid(userid);
			c.setProductid(id);
			c.setQuantity(quantity);
			c.setBillingaddress(address);
			c.setShippingaddress(address);
			
			this.cartdao.insert(c);		
		}
		return mv;
	}
}

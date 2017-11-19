package com.hibernate;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.cart.Cart;
import com.hibernate.cart.CartDAO;
import com.hibernate.customer.Customers;
import com.hibernate.customer.CustomersDAO;
import com.hibernate.products.Products;
import com.hibernate.products.ProductsDAO;

@RestController
public class RESTController {

	@Autowired
	CartDAO cartdao;
	
	@Autowired
	ProductsDAO pdao;
	
	@Autowired
	CustomersDAO pfdao;
	
	@RequestMapping(value="/getAllCartItems",method=RequestMethod.POST)
	public String getAllCartItems(HttpSession sessions)
	{	
		int currUser = 0;		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null && !auth.getName().equals("anonymousUser"))
	    	currUser = Integer.parseInt(sessions.getAttribute("userId").toString());
		
		JSONArray jarr = new JSONArray();
		
		for( Cart c : cartdao.getAllCart() )
		{
			if( c.getCustomerid() == currUser )
			{
				JSONObject jobj = new JSONObject();
				
				Products p = pdao.getProductsbyId(c.getProductid());		
				jobj.put("qty", c.getQuantity());
				jobj.put("id", c.getId());
				jobj.put("pname",  p.getProductname() );
				jobj.put("pdesc", p.getProductdescription());
				jobj.put("pprice", p.getProductprice());
				jobj.put("pimg", p.getProductimage());
				jobj.put("shipaddr", c.getShippingaddress());
				jobj.put("billaddr", c.getBillingaddress());	
				jarr.add(jobj);
			}
			
		}
			
		return jarr.toJSONString();
	}
	
	
	@RequestMapping(value="/deletefromcart",method=RequestMethod.POST)
	public String deletefromcart(@RequestBody String data)
	{

		try{
			JSONParser jparr = new JSONParser();
			
			JSONObject inp = (JSONObject)jparr.parse(data);
			
			System.out.println(inp);
			
			int id = Integer.parseInt( inp.get("id").toString() );
			
			cartdao.delete(id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return "{\"msg\":\"Deleted\"}";
	}
	
	@RequestMapping(value="/getAddress",method=RequestMethod.POST)
	public String getAddress(HttpSession sessions)
	{
		
		int currUser = 0;		
		System.out.println(currUser);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null && !auth.getName().equals("anonymousUser"))
	    	currUser = Integer.parseInt(sessions.getAttribute("userId").toString());
	    System.out.println(currUser);
	    JSONObject jobj = new JSONObject();
	    Cart cart = cartdao.getCartbyId(currUser);
	    System.out.println(cart.getCustomerid());
		for( Customers c : pfdao.getAllUsers() )
		{
			System.out.println(c.getId());
			System.out.println(currUser);
			if( c.getId() == currUser )
			{	
				String addr = c.getAddress1();
				System.out.println(addr);
				jobj.put("billaddr", cart.getBillingaddress());
				jobj.put("shipaddr", cart.getShippingaddress());
				System.out.println(cart.getBillingaddress());
				System.out.println(cart.getShippingaddress());
				return jobj.toJSONString();
			}	
		}
		return jobj.toJSONString();
	}
	
	
	@RequestMapping(value="/UpdateCartToDB",method=RequestMethod.POST)
	public String UpdateCartToDB(@RequestBody String data , HttpSession sessions)
	{
		
		int currUser = 0;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null && !auth.getName().equals("anonymousUser"))
	    	currUser = Integer.parseInt(sessions.getAttribute("userId").toString());
	    
		try{
			JSONParser jparr = new JSONParser();
			
			JSONObject inp = (JSONObject)jparr.parse(data);
			
			String ship = inp.get("ship").toString();
			String bill = inp.get("bill").toString();
			cartdao.update(currUser, ship, bill);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return "{\"msg\":\"Updated\"}";
	    
	    
	}
	
	@RequestMapping(value="/DeleteCartItems",method=RequestMethod.POST)
	public String DeleteCartItems(HttpSession sessions)
	{

		int currUser = 0;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null && !auth.getName().equals("anonymousUser"))
	    	currUser = Integer.parseInt(sessions.getAttribute("userId").toString());

		for( Cart c : cartdao.getAllCart() )
		{
			if( c.getCustomerid() == currUser )
			{		
				int a=c.getId();
				cartdao.delete(a);			
			}		
		}
		return "{\"msg\":\"Deleted Items\"}";
	}
}





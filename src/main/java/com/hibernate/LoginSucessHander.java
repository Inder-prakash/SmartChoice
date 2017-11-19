package com.hibernate;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.hibernate.customer.CustomersDAO;
import com.hibernate.loginhistory.LoginHistory;
import com.hibernate.loginhistory.LoginHistoryDAO;

public class LoginSucessHander implements AuthenticationSuccessHandler{
	@Autowired
	LoginHistoryDAO lhdao;
	@Autowired
	CustomersDAO custdao;
	
	public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2)
			throws IOException, ServletException {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date date = new Date();
		String sd = df.format(date);
		LoginHistory lh = new LoginHistory();
		lh.setUsername(arg0.getParameter("email"));
		lh.setPassword(arg0.getParameter("password"));
		lh.setStatus("Valid");
		lh.setLogintime(sd.toString());
        lhdao.insert(lh);   
        HttpSession session = arg0.getSession();
        session.setAttribute("userName",custdao.getCustomer(arg0.getParameter("email")));
        session.setAttribute("userId",custdao.getCustomerId(arg0.getParameter("email")));
        arg1.sendRedirect("index");
	}
	
}

package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;
import model.Customer;

@WebServlet("/Register")
public class Register extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
		try
		{
		String username=request.getParameter("username");
		String password1=request.getParameter("passwd");
		String customerName=request.getParameter("customerName");
		String gender=request.getParameter("gender");
		String mobileNo=request.getParameter("mobileNo");
		String emailid=request.getParameter("emailid");
		String custAddr=request.getParameter("custAddr");
		
		out.println("User Name:"+username);
		out.println("Password:"+password1);
		out.println("Customer Name:"+customerName);
		out.println("Gender:"+gender);
		out.println("Mobile No:"+mobileNo);
		out.println("emailId:"+emailid);
		out.println("CustomerAddr"+custAddr);
		
		Customer customer=new Customer(username,password1,customerName,gender,mobileNo,emailid,custAddr);
		
		RegisterDAO registerDAO=new RegisterDAO();
		
			if(registerDAO.registerCustomer(customer))
			{
				request.setAttribute("username", customer.getUsername());
				RequestDispatcher dispatch=request.getRequestDispatcher("UserHome.jsp");
				dispatch.forward(request, response);
			}
			else
			{
				request.setAttribute("errorInfo","Error Occured During Registering");
				RequestDispatcher dispatch=request.getRequestDispatcher("ErrorPage.jsp");
				dispatch.forward(request, response);
			}
		
		}
		catch(Exception e)
		{
			request.setAttribute("errorInfo","Error Occured During Registering::::"+e.getMessage());
			RequestDispatcher dispatch=request.getRequestDispatcher("ErrorPage.jsp");
			dispatch.forward(request, response);
		}
		
	}

}



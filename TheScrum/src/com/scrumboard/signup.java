package com.scrumboard;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
public class signup extends HttpServlet
{
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
{
	RequestDispatcher dispatcher;
	boolean flag;
String name=request.getParameter("user-name");
String email=request.getParameter("user-email");
String password=request.getParameter("user-password");
System.out.println("name: "+name+"email: "+email+"password: "+password);


//create or update user
flag= User.creatorUpdateUser(name,email,password);
System.out.println("the flag value is:"+flag);
if(flag)
{
	System.out.println("success");
	dispatcher=getServletContext().getRequestDispatcher("/todo.html");
 dispatcher.forward(request, response);
}
else
{
	System.out.println("failed");
	dispatcher=getServletContext().getRequestDispatcher("/scrumboard.html");
 dispatcher.forward(request, response);	
}


}
}

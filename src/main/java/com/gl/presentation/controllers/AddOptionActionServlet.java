package com.gl.presentation.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gl.beans.Option;
import com.gl.business.DefaultServices;

/**
 * Servlet implementation class AddOptionActionServlet
 */
@WebServlet("/addOptionAction")
public class AddOptionActionServlet extends HttpServlet {
     
    
	public AddOptionActionServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Nom=request.getParameter("Nom");
		String description=request.getParameter("description");
		Option option = new Option();
		option.setNom(Nom);
		option.setDescription(description);
		try {
			DefaultServices.getInstance().addOption(option);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("addOption").forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

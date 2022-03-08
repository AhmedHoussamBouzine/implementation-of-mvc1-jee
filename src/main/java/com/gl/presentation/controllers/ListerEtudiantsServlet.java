package com.gl.presentation.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gl.beans.Etudiant;
import com.gl.business.DefaultServices;

/**
 * Servlet implementation class ListerEtudiantsServlet
 */
@WebServlet("/listEtudiant")
public class ListerEtudiantsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String string = request.getParameter("nom");
		try {
			if(string == null) {
				List<Etudiant> etudiants = DefaultServices.getInstance().getEtudiants();
				request.setAttribute("etudiants", etudiants);
				request.getRequestDispatcher("/WEB-INF/ListEtudiant.jsp").forward(request, response);
			}
			else {
				List<Etudiant> etudiants = DefaultServices.getInstance().getEtudiantsByOptions(string);
				request.setAttribute("etudiants", etudiants);
				request.getRequestDispatcher("/WEB-INF/ListEtudiant.jsp").forward(request, response);
						
			}
			}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

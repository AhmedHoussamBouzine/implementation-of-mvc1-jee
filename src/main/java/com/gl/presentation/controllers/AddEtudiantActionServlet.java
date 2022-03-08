package com.gl.presentation.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gl.beans.Etudiant;
import com.gl.beans.Option;
import com.gl.business.DefaultServices;

/**
 * Servlet implementation class AddEtudiantActionServlet
 */
@WebServlet("/addEtudiantAction")
public class AddEtudiantActionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		

		try {
			String cne=request.getParameter("cne");
			String nom=request.getParameter("Nom");
			String prenom=request.getParameter("Prenom");
			String option=request.getParameter("option");
			
			Etudiant etudiant = new Etudiant();
			etudiant.setCne(cne);
			etudiant.setNom(nom);
			etudiant.setPrenom(prenom);
			etudiant.setOption(DefaultServices.getInstance().getOption(option));
			DefaultServices.getInstance().addEtudiant(etudiant);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("addEtudiant").forward(request, response);
	}

}

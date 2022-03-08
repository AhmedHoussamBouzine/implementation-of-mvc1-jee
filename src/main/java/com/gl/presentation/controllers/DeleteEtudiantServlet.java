package com.gl.presentation.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gl.beans.Etudiant;
import com.gl.business.DefaultServices;

/**
 * Servlet implementation class DeleteEtudiantServlet
 */
@WebServlet("/deleteEtudiant")
public class DeleteEtudiantServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String cne = request.getParameter("cne");
			Etudiant etudiant = DefaultServices.getInstance().getEtudiant(cne);
			DefaultServices.getInstance().deleteEtudiant(etudiant);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		request.getRequestDispatcher("listEtudiant").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

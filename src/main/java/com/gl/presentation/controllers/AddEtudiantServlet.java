package com.gl.presentation.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gl.beans.Option;
import com.gl.business.DefaultServices;

/**
 * Servlet implementation class AddEtudiantServlet
 */
@WebServlet("/addEtudiant")
public class AddEtudiantServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Option> options = DefaultServices.getInstance().getOptions();
			request.setAttribute("options", options);
			request.getRequestDispatcher("/WEB-INF/AddEtudiant.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

<%@page import="com.gl.beans.Etudiant"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<Etudiant> etudians= (List<Etudiant>) request.getAttribute("etudiants");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/main.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css">
<title>Insert title here</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
	<h1 class="text-center">Liste des Etudiants</h1>
	<table class="table">
	<thead class="thead-dark">
	<tr>
	<th scope="col"> Cne </th> <th scope="col"> Nom </th> <th scope="col"> Prenom </th> <th scope="col"> Option </th> <th scope="col"> Actions</th>
	</tr>
	<% for(Etudiant e:etudians){ %>
		<tr>
			<td><%= e.getCne() %></td>
			<td><%= e.getNom() %></td>
			<td><%= e.getPrenom() %></td>
			<% 
			if(e.getOption() != null){
			%>
			<td><%= e.getOption().getNom()%></td>
			<% }else{
			%>
			<td>null</td>
			<%} %>
			<td><a href="deleteEtudiant?cne=<%= e.getCne() %>" ><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="black" class="bi bi-person-x-fill" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm6.146-2.854a.5.5 0 0 1 .708 0L14 6.293l1.146-1.147a.5.5 0 0 1 .708.708L14.707 7l1.147 1.146a.5.5 0 0 1-.708.708L14 7.707l-1.146 1.147a.5.5 0 0 1-.708-.708L13.293 7l-1.147-1.146a.5.5 0 0 1 0-.708z"/>
</svg></a></td>
		</tr>
		<%}%>
		</thead>
	</table>
</body>
</html>
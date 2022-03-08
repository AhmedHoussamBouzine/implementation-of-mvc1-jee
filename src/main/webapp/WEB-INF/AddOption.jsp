<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/main.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.13.0/css/all.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container-fluid ">
		<div class="row">
			<h1 class="text-center" >Add Option</h1>
			<div class="form-group" name="form">
				<form action="addOptionAction" method="post" class="row g-3">

					<div class="col-md-6">
						<label for="Nom" class="form-label">Nom</label> <input
							class="form-control" name="Nom" type="text">
					</div>
					<div class="col-md-6">
						<label for="description" class="form-label">Description</label> <input
							class="form-control" name="description" type="text">
					</div>
					<div class="col-md-12  text-center">
						<button class="btn btn-dark" type="submit">submit</button>
						<button class="btn btn-dark" type="reset">reset</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
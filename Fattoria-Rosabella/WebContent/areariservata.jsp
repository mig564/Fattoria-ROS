<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"  import="java.util.*"%>
<%Boolean adminRoles = (Boolean) session.getAttribute("adminFilterRoles");
if ((adminRoles == null) || (!adminRoles.booleanValue())){	
   	response.sendRedirect("./login-form-filter.jsp");
   	return;
} %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="css/style.css" rel="stylesheet">
		<!-- Bootstrap CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
			crossorigin="anonymous">
		
		<title>Fattoria Rosabella</title>
	</head>

	<body>
		<nav class="navbar navbar-expand-lg navbar-light">
  			<div class="container">
    		<a class="navbar-brand" href="index.jsp">
    			<img src="img/Logo.svg" alt="logo" height="40px">
    		</a>
    		
    		<!-- Button to Mobile Navbar -->
    		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      			<span class="navbar-toggler-icon"></span>
    		</button>
    		
	    		<div class="collapse navbar-collapse" id="navbarSupportedContent">
	              	<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item dropdown">
							<button type="button" class="btn btn-outline-success" onclick="window.location.href='./LogoutAdmin'">
  								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-left" viewBox="0 0 16 16">
 									<path fill-rule="evenodd" d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0v2z"/>
 									<path fill-rule="evenodd" d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"/>
								</svg> LOGOUT
							</button>
  						</li>
  					</ul>
    			</div>
  			</div>
		</nav>
		
		<!-- Corpo della pagina -->
		<div class="container">
			<h3 class="text-center title-green" style="margin-top: 40px;">Benvenuto, utenteX</h3>
			<p class="text-center" style="margin-bottom: 40px;">Questà è una sezione riservata</p>
			
			<!-- Colonne -->
			<div class="row">
				<div class="col-md-6">
					<p class="text-center"><button type="button" class="btn btn-primary btn-lg" onclick="window.location.href='attivitariservate.jsp'">Attività</button></p>
				</div>
				
				<div class="col-md-6">
					<p class="text-center"><button type="button" class="btn btn-primary btn-lg" onclick="window.location.href='prenotazioniriservate.jsp'">Prenotazioni</button></p>
				</div>
			</div>
		</div>

		<!-- Bootstrap - JavaScript -->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
			crossorigin="anonymous">
		</script>
	</body>
</html>
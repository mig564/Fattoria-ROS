<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"  import="java.util.*" import="beans.Attivita"%>
<%
Collection<?> attivita = (Collection<?>) request.getAttribute("attivita");
if (attivita == null) {
	response.sendRedirect(response.encodeRedirectURL("./CarrelloControl"));
	return;
}%>
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
	        			<li class="nav-item"><a class="nav-link active" aria-current="page" href="index.jsp">HOME</a></li>
						<li class="nav-item"><a class="nav-link" href="attivita.jsp">ATTIVITÀ</a></li>
						<li class="nav-item"><a class="nav-link" href="prenotazioni.jsp">PRENOTAZIONI</a></li>
						<li class="nav-item"><a class="nav-link" href="contatti.jsp">CONTATTI</a></li>
					</ul>
	              
	      			<div class="d-flex">
	        			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
  							<li class="nav-item dropdown">
					  			<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"	role="button" data-bs-toggle="dropdown" aria-expanded="false">
									<svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" class="bi bi-person-circle" viewBox="0 0 16 16">
	 				 					<path d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z"/>
	  									<path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
	  									<path fill-rule="evenodd" d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z"/>
									</svg>
								</a>
								<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
									<li><a class="dropdown-item" href="ilmioprofilo.jsp">Il mio profilo</a></li>
									<li><a class="dropdown-item" href="lemieprenotazioni.jsp">Le mie prenotazioni</a></li>
									<li><a class="dropdown-item" href="lemiecarte.jsp">Le mie carte</a></li>
									<li><hr class="dropdown-divider"></li>
									<li><a class="dropdown-item" onclick="window.location.href='./Logout'">Logout</a></li>
								</ul>
							</li>
						</ul>
	      			</div>
    			</div>
  			</div>
		</nav>
		
		<div class="container">
			<h3 class="text-center title-green">Riepilogo Ordine</h3>
		</div>
			
		<!-- card orizzontale per attività -->
		<div class="container">
			<%if (attivita != null && attivita.size() > 0) {
				Iterator<?> iterator =  attivita.iterator();
				while(iterator.hasNext()){
					Attivita bean = (Attivita) iterator.next();%>
					<div class="row" style="margin-top: 60px;">
						<div class="col-md-5 cover-img" style="background-image: url('img/<%=bean.getNome() %>.jpg'); border-radius: 30px 0px 0px 30px;"></div>
						<div class="col-md-7" style="background-color: white; border-radius: 0px 30px 30px 0px; border: 1px solid rgba(0,0,0,.125); padding: 22px;">
							<h3 class="title-green"><%=bean.getNome()%></h3> 
							<p>Prezzo: <%=bean.getPrezzo()%> $</p>
							<p>Orario <select style="margin-left: 5px;">
								<option value="10:00-11:00" selected="selected">10:00-11:00 </option>
								<option value="orario1">09:00-10:00 </option>
								<option value="orario2">08:00-09:00 </option></select></p> 
							<p>partecipanti <select style="margin-left: 5px;">
								<option value="10:00-11:00" selected="selected">1 </option>
								<option value="part1">2 </option>
								<option value="part2">3 </option></select>
							<span>
								<p style="text-align: right; margin-right: 26px;">
									<button type="submit" class="btn btn-success btn-lg" style="margin-right: 22px;">Prenota</button>
									<button type="reset" class="btn btn-danger btn-lg">Elimina</button>
								</p>
							</span>
						</div>
					</div>
					  
				
						
			<%	}%>
				<p class="text-center" style="margin-top: 32px;">
					<a class="btn btn-success btn-lg" href="pagamento.jsp">Procedi al pagamento</a>
				</p>
				</div>
			<%} else {%>
				<p>Non ci sono attivita</p>
		<%	} %>
			
    		
    		
		<!-- Footer -->
		<div class="container-fluid" style="background-color: #198754; margin-top: 42px; padding: 22px 0px;">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						
					</div>
					
					<div class="col-md-6">
						<p class="text-center"><img alt="" src="img/Icon.svg" height="60px"></p>
						<h5 class="text-center" style="color: white;">FATTORIA ROSABELLA Cop.</h5>
						<p class="text-center" style="color: white;">
							Via Serritiello 49/a - Pratola Serra (AV)<br>
							fattoriarosabella@gmail.com<br>
							0825 973568</p>
							<p class="text-center"><span>
								<svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="white" style="color: white; margin: 6px" class="bi bi-facebook" viewBox="0 0 16 16">
  									<path d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z"/>
								</svg>
								<svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" style="color: white; margin: 6px" class="bi bi-instagram" viewBox="0 0 16 16">
 				 					<path d="M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.917 3.917 0 0 0-1.417.923A3.927 3.927 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.916 3.916 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.926 3.926 0 0 0-.923-1.417A3.911 3.911 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0h.003zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599.28.28.453.546.598.92.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.47 2.47 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.478 2.478 0 0 1-.92-.598 2.48 2.48 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233 0-2.136.008-2.388.046-3.231.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92.28-.28.546-.453.92-.598.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045v.002zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92zm-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217zm0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334z"/>
								</svg>
								<svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" style="color: white; margin: 6px" class="bi bi-twitter" viewBox="0 0 16 16">
  									<path d="M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z"/>
								</svg>
							</span></p>
					</div>
					
					<div class="col-md-3">
						<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d12047.725951161714!2d14.841000435481634!3d40.98298103685627!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133a2d62e2c79683%3A0x7cfea53f3aad8f85!2sVia%20Serritiello%2C%2049%2C%2083039%20Pratola%20Serra%20AV!5e0!3m2!1sit!2sit!4v1609192591650!5m2!1sit!2sit" width="" height="220" aria-hidden="false" tabindex="0"></iframe>
					</div>
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
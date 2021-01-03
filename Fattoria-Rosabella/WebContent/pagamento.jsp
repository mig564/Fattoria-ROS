<%@page import="beans.CartaDiCredito"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"  import="java.util.*" import="beans.CartaDiCredito"%>
<%	
Collection<?> carte = (Collection<?>) request.getAttribute("carte"); 
if (carte == null) {
	response.sendRedirect(response.encodeRedirectURL("./PagamentoControl"));
	return; 
}

boolean log = false;	%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="script/carta.js"></script>
		<link href="css/style.css" rel="stylesheet">
		<!-- Bootstrap CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
			crossorigin="anonymous">
		<script src="script/prenotazioni.js"></script>
		
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
							<%if (log == false) { %>
								<li class="nav-item dropdown">
  									<button type="button" class="btn btn-outline-success" onclick="window.location.href='login.jsp'">
  										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-in-right icon-position" viewBox="0 0 16 16" style="margin-top: -3px; margin-right: 6px;">
 											<path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z"/>
 											<path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
										</svg> LOGIN
									</button>
  								</li>
  							<%} else { %>
  								<li class="nav-item dropdown">
					  				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"	role="button" data-bs-toggle="dropdown" aria-expanded="false">
										<svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="$red-300" class="bi bi-person-circle" viewBox="0 0 16 16">
	 				 						<path d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z"/>
	  										<path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
	  										<path fill-rule="evenodd" d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z"/>
										</svg>
									</a>
									<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
										<li><a class="dropdown-item" href="#">Il mio profilo</a></li>
										<li><a class="dropdown-item" href="#">Le mie prenotazioni</a></li>
										<li><a class="dropdown-item" href="#">Le mie carte</a></li>
										<li><hr class="dropdown-divider"></li>
										<li><a class="dropdown-item" href="#">Logout</a></li>
									</ul>
								</li>
					    	<%} %>	
						</ul>
	      			</div>
    			</div>
  			</div>
		</nav>

		<a href="./PagamentoControl?action=paga">compra</a>
		<!-- Seleziona metodo di pagamento -->
		<div class="container" style="margin-top: 40px;">
			<h3 class="text-center title-green">PAGAMENTI</h3>
			<p class="text-center">Qui puoi effettuare i pagamenti</p>
			
			<div class="row" style="margin: 40px 0;">
				<div class="col-md-5">
					<h5>Seleziona il metodo di pagamento:</h5>
				</div>
				<div class="col-md-7">
					<div class="form-check form-check-inline">
  						<input class="form-check-input custom-control-input" type="radio" name="selezionaMetedo" id="radioCartaDiCredito" value="Carta di credito" onclick="showCarteDiCredito();">
  						<label class="form-check-label custom-control-label" for="radioCartaDiCredito">Carta di credito</label>
					</div>
					<div class="form-check form-check-inline">
  						<input class="form-check-input custom-control-input" type="radio" name="selezionaMetedo" id="radioInSede" value="in sede">
  						<label class="form-check-label custom-control-label" for="radioInSede">In sede</label>
					</div>
				</div>
			</div>
		</div>
		
		<!-- Carte di credito -->
		<div class="container card" id="carte" style="display: none;">
			<h3 class="text-center title-green" style="margin: 40px;">Le mie carte</h3>
			<!-- Carte registrate dall'utente -->
			<div class="row" style="padding: 8px 0;">
				<div class="col-sm-2 mx-auto">
					<div class="form-check form-check-inline" style="padding-left: 40px;">
  						<input class="form-check-input custom-control-input" type="radio" name="selezionaCarta" id="carta1" value="carta1">
					</div>
				</div>
				
				<%
				if(carte != null && carte.size() > 0) {
				Iterator<?> iterator =  carte.iterator();
				while(iterator.hasNext()) {
					CartaDiCredito bean = (CartaDiCredito) iterator.next();%>
					
		
				<div class="col-sm-4 mx-auto">
					<p class="text-center"><%=bean.getIntestatrio() %></p>
				</div>
				<div class="col-sm-4 mx-auto">
					<p class="text-center"><%=bean.getNumero() %></p>
				</div>
				<div class="col-sm-2 mx-auto">
					<p class="text-center"><%=bean.getScadenza() %></p>
				</div>
			</div>
			<%	}
			} else {%>
				<p>Non ci sono carte</p>
		<%	} %>
						
			<!-- Form per aggiunta di una nuova carta -->
			<div class="row" style="margin: 0 32px;">
				<p class="text-center"><button type="button" class="btn btn-link" style="color: green; text-decoration: none;" onclick="showFormAggiungiCarta()">
  					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
  						<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
  						<path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
					</svg> Aggiungi una nuova carta
				</button></p>
				<!-- Form di aggiunta carta -->
				<form name="aggiungicarta" method="post" action="CarteControl?action=aggiungi" onSubmit="" style="display: none;">
					<h3 class="text-center title-green" style="margin-bottom: 22px;">REGISTRAZIONE</h3>
					<div class="form-floating" style="margin-bottom: 12px;">
						<input type="number" name="numero" class="form-control" id="campoNumeroCarta"  placeholder="0055 1234 1234 1234">
						<label for="campoNumeroCarta">Numero carta</label>
					</div>
					<div class="form-floating" style="margin-bottom: 12px;">
						<input type="text" name="nome" class="form-control" id="nomeUtente"  placeholder="Nome">
						<label for="nomeUtente">Nome intestatario</label>
					</div>
					<div class="form-floating" style="margin-bottom: 12px;">
						<input type="text" name="cognome" class="form-control" id="cognomeUtente"  placeholder="Cognome">
						<label for="cognomeUtente">Cogome intestatario</label>
					</div>
					<div class="form-floating" style="margin-bottom: 12px;">
						<input type="number" name="cvv" class="form-control" id="campoCVV"  placeholder="CVV">
						<label for="campoCVV">CVV</label>
					</div>
					<div class="row" style="margin-bottom: 12px;">
						<div class="col">
							<div class="form-floating">
								<select name="mese" class="form-select" id="selezionaMese" aria-label="Seleziona mese">
	 							 	<option value="1">Gennaio</option>
	 							 	<option value="2">Febbraio</option>
	 							 	<option value="3">Marzo</option>
	 							 	<option value="4">Aprile</option>
		 						 	<option value="5">Maggio</option>
		 						 	<option value="6">Giugno</option>
		 						 	<option value="7">Luglio</option>
		 						 	<option value="8">Agosto</option>
		 						 	<option value="9">Settembre</option>
		 						 	<option value="10">Ottobre</option>
		 						 	<option value="11">Novembre</option>
		 						 	<option value="12">Dicembre</option>
		 						 </select>
		 						 <label for="selezionaMese">Mese di scadenza</label>
		 					</div>
						</div>
						<div class="col">
							<div class="form-floating">
								<select name="anno" class="form-select" id="selezionaAnno" aria-label="Seleziona mese">
		 						 	<option value="2021">2021</option>
		 						 	<option value="2022">2022</option>
		 						 	<option value="2023">2023</option>
		 						 	<option value="2024">2024</option>
		 						 	<option value="2025">2025</option>
		 						 	<option value="2026">2026</option>
		 						 	<option value="2027">2027</option>
		 						 	<option value="2028">2028</option>
								 </select>
								 <label for="selezionaMese">Anno di scadenza</label>
							 </div>
						</div>
					</div>
					
					<p class="text-center"><button type="submit" class="btn btn-success">AGGIUNGI</button></p>
				</form>
			</div>
		</div>
		
		<!-- Footer -->
		<div class="container-fluid" style="background-color: #198754; margin-top: 100px; padding: 22px 0px;">
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
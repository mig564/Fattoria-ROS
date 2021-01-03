<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"  import="java.util.*" import="beans.CartaDiCredito"%>
<%
Collection<?> carte = (Collection<?>) request.getAttribute("carte");
if (carte == null) {
	response.sendRedirect(response.encodeRedirectURL("./CarteControl"));
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
		
		<title>Le mie carte</title>
	</head>

	<body>
		<!-- Header menu -->
		<nav class="navbar navbar-expand-lg navbar-light">
  			<div class="container">
    		<a class="navbar-brand" href="#">
    			<img src="img/Logo.svg" alt="logo" height="40px">
    		</a>
    		
    		<!-- Button to Mobile Navbar -->
    		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      			<span class="navbar-toggler-icon"></span>
    		</button>
    		
	    		<div class="collapse navbar-collapse" id="navbarSupportedContent">
	      			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        			<li class="nav-item"><a class="nav-link active" aria-current="page" href="#">HOME</a></li>
						<li class="nav-item"><a class="nav-link" href="#">ATTIVITÀ</a></li>
						<li class="nav-item"><a class="nav-link" href="#">PRENOTAZIONI</a></li>
						<li class="nav-item"><a class="nav-link" href="#">CONTATTI</a></li>
					</ul>
	              
	      			<div class="d-flex">
	        			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
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
						</ul>
	      			</div>
    			</div>
  			</div>
		</nav>
		
		<!-- Carte -->
		<h3 class="text-center title-green" style="margin: 40px;">Le mie carte</h3>
		<div class="container card">
		
			<!-- Carte registrate dall'utente -->
			<%if(carte != null && carte.size() > 0) {
				Iterator<?> iterator =  carte.iterator();
				while(iterator.hasNext()){
				CartaDiCredito bean = (CartaDiCredito) iterator.next();%>
				<p><%=bean.getIntestatrio() %></p>
				
				<%	}
			} else {%>
				<p>Non ci sono carte</p>
		<%	} %>
			
			<div class="row" style="padding: 8px 0;">
				<div class="col-sm-1 mx-auto">
					<p class="text-center"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-credit-card-2-back" viewBox="0 0 16 16">
  						<path d="M11 5.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1z"/>
 						<path d="M2 2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V4a2 2 0 0 0-2-2H2zm13 2v5H1V4a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1zm-1 9H2a1 1 0 0 1-1-1v-1h14v1a1 1 0 0 1-1 1z"/>
						</svg></p>
				</div>
				<div class="col-sm-3 mx-auto">
					<p class="text-center">Carmine Pastore</p>
				</div>
				<div class="col-sm-3 mx-auto">
					<p class="text-center">**** **** **** 9875</p>
				</div>
				<div class="col-sm-2 mx-auto">
					<p class="text-center">07/26</p>
				</div>
				<div class="col-sm-3 mx-auto">
					<p class="text-center"><button type="button" class="btn btn-link" style="color:red; text-decoration: none;" onclick="">
  						<svg xmlns="http://www.w3.org/2000/svg" style="margin-top: -3px;" width="16" height="16" fill="currentColor" class="bi bi-x-octagon" viewBox="0 0 16 16">
  							<path d="M4.54.146A.5.5 0 0 1 4.893 0h6.214a.5.5 0 0 1 .353.146l4.394 4.394a.5.5 0 0 1 .146.353v6.214a.5.5 0 0 1-.146.353l-4.394 4.394a.5.5 0 0 1-.353.146H4.893a.5.5 0 0 1-.353-.146L.146 11.46A.5.5 0 0 1 0 11.107V4.893a.5.5 0 0 1 .146-.353L4.54.146zM5.1 1L1 5.1v5.8L5.1 15h5.8l4.1-4.1V5.1L10.9 1H5.1z"/>
  							<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
						</svg> Elimina
					</button></p>
				</div>
			</div>
			<hr>
			
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
						<input name="numero" type="number" class="form-control" id="campoNumeroCarta"  placeholder="0055 1234 1234 1234">
						<label for="campoNumeroCarta">Numero carta</label>
					</div>
					<div class="form-floating" style="margin-bottom: 12px;">
						<input name="nome" type="text" class="form-control" id="nomeUtente"  placeholder="Nome">
						<label for="nomeUtente">Nome intestatario</label>
					</div>
					<div class="form-floating" style="margin-bottom: 12px;">
						<input name="cognome" type="text" class="form-control" id="cognomeUtente"  placeholder="Cognome">
						<label for="cognomeUtente">Cogome intestatario</label>
					</div>
					<div class="form-floating" style="margin-bottom: 12px;">
						<input name="cvv" type="number" class="form-control" id="campoCVV"  placeholder="CVV">
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
			
		
		<!-- Bootstrap - JavaScript -->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
			crossorigin="anonymous">
		</script>
</body>
</html>





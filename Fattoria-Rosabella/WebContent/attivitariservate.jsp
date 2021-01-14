<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"  import="java.util.*"%>
<%Boolean adminRoles = (Boolean) session.getAttribute("adminFilterRoles");
if ((adminRoles == null) || (!adminRoles.booleanValue())) {	
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
							<button type="button" class="btn btn-outline-success" onclick="">
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
			<p class="text-center" style="margin-bottom: 40px;">Sezione gestione attività</p>
			<p class="text-center"><button type="button" class="btn btn-link" style="color: green; text-decoration: none;" onclick="showFormAggiungiCarta()">
  				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
  					<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
  					<path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
				</svg> Aggiungi una nuova attività
			</button></p>
			
			<!-- Form aggiunta attività -->
			<form name="aggiungiattivita" method="post" action="AdminControl?tipo=attiva&action=aggiungi" onSubmit="" style="display: block;">
					<div class="form-floating" style="margin-bottom: 12px;">
						<input type="text" class="form-control" id="nome" name="nome" placeholder="">
						<label for="nome">Nome attività</label>
					</div>
					<div class="form-floating" style="margin-bottom: 12px;">
						<select class="form-select" name="categoria" id="categoria" aria-label="Seleziona categoria">
	 					 	<option value="1">Escursione</option>
	 					 	<option value="2">Visita guidata</option>
	 					 	<option value="3">Fattoria didattica</option>
	 					 	<option value="4">Balneazione</option>
		 				 	<option value="5">Ristoro</option>
		 				 </select>
		 				 <label for="categoria">Categoria</label>
		 			</div>
					<div class="form-floating" style="margin-bottom: 12px;">
						<input type="number" class="form-control" name="numeroParticipanti" id="numeroParticipanti"  placeholder="">
						<label for="numeroParticipanti">Numero massimo di partecipanti</label>
					</div>
						<div class="form-floating" style="margin-bottom: 12px;">
						<input type="number" class="form-control" name="prezzoAttività" id="prezzoAttività"  placeholder="">
						<label for="prezzoAttività">Prezzo</label>
					</div>
					<div class="form-floating" style="margin-bottom: 12px;">
						<input type="text" class="form-control" name="descrizioneAttività" id="descrizioneAttività"  placeholder="">
						<label for="descrizioneAttività">Descrizione</label>
					</div>
					
					<div class="form-floating" style="margin-bottom: 12px;">
						<div class="form-check form-check-inline">
							<p>Orario: </p>
							<input class="form-check-input" type="checkbox" name="orario" id="checkOrario9" value="09:00:00">
							<label class="form-check-label" for="checkOrario9">9:00</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="orario" id="checkOrario10" value="10:00:00">
							<label class="form-check-label" for="checkOrario10">10:00</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="orario" id="checkOrario10" value="10:00:00">
							<label class="form-check-label" for="checkOrario10">12:00</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="orario" id="checkOrario14" value="14:00:00">
							<label class="form-check-label" for="checkOrario14">14:00</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="orario" id="checkOrario15" value="15:00:00">
							<label class="form-check-label" for="checkOrario15">15:00</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="orario" id="checkOrario18" value="18:00:00">
							<label class="form-check-label" for="checkOrario18">18:00</label>
						</div>
					</div>
					<hr>
							
					<div class="form-floating" style="margin-bottom: 12px;">
						<div class="form-check form-check-inline"  style="margin-bottom: 12px;">
							<p>Giorni: </p>
							<input class="form-check-input" type="checkbox" name="giorno" id="checkGiornoLunedi" value="Lunedì">
							<label class="form-check-label" for="checkGiornoLunedi">Lunedì</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="giorno" id="checkGiornoMartedi" value="Martedì">
							<label class="form-check-label" for="checkGiornoMartedi">Martedì</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="giorno" id="checkGiornoMercoledi" value="Mercoledì">
							<label class="form-check-label" for="checkGiornoMercoledi">Mercoledì</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="giorno" id="checkGiornoGiovedi" value="Giovedì">
							<label class="form-check-label" for="checkGiornoGiovedi">Giovedì</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="giorno" id="checkGiornoVenerdi" value="Venerdì">
							<label class="form-check-label" for="checkGiornoVenerdi">Venerdì</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="giorno" id="checkGiornoSabato" value="Sabato">
							<label class="form-check-label" for="checkGiornoSabato">Sabato</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="giorno" id="checkGiornoDomenica" value="Domenica">
							<label class="form-check-label" for="checkGiornoDomenica">Domenica</label>
						</div>
					</div>
					<hr>
					
					<div class="form-floating" style="margin-bottom: 12px;">
						<div class="form-check form-check-inline"  style="margin-bottom: 12px;">
							<p>Mesi: </p>
							<input class="form-check-input" type="checkbox" name="mese" id="checkMeseGennaio" value="Gennaio">
							<label class="form-check-label" for="checkMeseGennaio">Gennaio</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="mese" id="checkMeseFebbraio" value="Febbraio">
							<label class="form-check-label" for="checkMeseFebbraio">Febbraio</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="mese" id="checkMeseMarzo" value="Marzo">
							<label class="form-check-label" for="checkMeseMarzo">Marzo</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="mese" id="checkMeseAprile" value="Aprile">
							<label class="form-check-label" for="checkMeseAprile">Aprile</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="mese" id="checkMeseMaggio" value="Maggio">
							<label class="form-check-label" for="checkMeseMaggio">Maggio</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="mese" id="checkMeseGiugno" value="Giugno">
							<label class="form-check-label" for="checkMeseGiugno">Giugno</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="mese" id="checkMeseLuglio" value="Luglio">
							<label class="form-check-label" for="checkMeseLuglio">Luglio</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="mese" id="checkMeseAgosto" value="Agosto">
							<label class="form-check-label" for="checkMeseAgosto">Agosto</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="mese" id="checkMeseSettembre" value="Settembre">
							<label class="form-check-label" for="checkMeseSettembre">Settembre</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="mese" id="checkMeseOttobre" value="Ottobre">
							<label class="form-check-label" for="checkMeseOttobre">Ottobre</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="mese" id="checkMeseNovembre" value="Novembre">
							<label class="form-check-label" for="checkMeseNovembre">Novembre</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="mese" id="checkMeseDicembre" value="Dicembre">
							<label class="form-check-label" for="checkMeseDicembre">Dicembre</label>
						</div>
					</div>
					
					<p class="text-center"><button type="submit" class="btn btn-success">AGGIUNGI</button></p>
				</form>
		</div>

		<!-- Bootstrap - JavaScript -->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
			crossorigin="anonymous">
		</script>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"  import="java.util.*"%>
<%@	page import="beans.Calendario"%>
<%@	page import="beans.Attivita" import="model.CalendarioModelDM"%>
<%Boolean adminRoles = (Boolean) session.getAttribute("adminFilterRoles");
if ((adminRoles == null) || (!adminRoles.booleanValue())) {	
   	response.sendRedirect("./login.jsp");
   	return;
} %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="css/style.css" rel="stylesheet">
		<script type="text/javascript" src="script/prenotazioni.js"></script>
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
			<h3 class="text-center title-green" style="margin-top: 40px;">Sezione gestione attività</h3>
			<p class="text-center"><button type="button" class="btn btn-link" style="color: green; text-decoration: none;" id="btnAggiungi" onclick="javascript:showAggiungiAttivita()">
  				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
  					<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
  					<path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
				</svg> Aggiungi una nuova attività
			</button></p>
			
			<!-- Form aggiunta attività -->
			<form name="aggiungiattivita" method="post" action="AdminControl?tipo=attivita&action=aggiungi" onSubmit="" style="display: none;">
					<div class="form-floating" style="margin-bottom: 12px;">
						<input type="text" class="form-control" id="nome" name="nome" placeholder="">
						<label for="nome">Nome attività</label>
					</div>
					<div class="form-floating" style="margin-bottom: 12px;">
						<select class="form-select" name="categoria" id="categoria" aria-label="Seleziona categoria">
	 					 	<option value="Escursione">Escursione</option>
	 					 	<option value="Visita guidata">Visita guidata</option>
	 					 	<option value="Fattoria didattica">Fattoria didattica</option>
	 					 	<option value="Balneazione">Balneazione</option>
		 				 	<option value="Ristoro">Ristoro</option>
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
							<input class="form-check-input" type="checkbox" name="orario" id="checkOrario10" value="12:00:00">
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
							<input class="form-check-input" type="checkbox" name="giorno" id="checkGiornoLunedi" value="Lunedi">
							<label class="form-check-label" for="checkGiornoLunedi">Lunedì</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="giorno" id="checkGiornoMartedi" value="Martedi">
							<label class="form-check-label" for="checkGiornoMartedi">Martedì</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="giorno" id="checkGiornoMercoledi" value="Mercoledi">
							<label class="form-check-label" for="checkGiornoMercoledi">Mercoledì</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="giorno" id="checkGiornoGiovedi" value="Giovedi">
							<label class="form-check-label" for="checkGiornoGiovedi">Giovedì</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="giorno" id="checkGiornoVenerdi" value="Venerdi">
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
		
		<!-- Attività disponibili -->
		<%
		Collection<?> attivita = (Collection<?>) request.getAttribute("attivita");
		if(attivita == null) response.sendRedirect("./AdminControl?tipo=attivita&action=tutto");
		if(attivita != null && attivita.size() > 0) {
			Iterator<?> iterator = attivita.iterator();
			while(iterator.hasNext()) {
				Attivita bean = (Attivita) iterator.next();
		%>
			<div class="container">
				<div class="row" style="margin-top: 30px;">
					<div class="col-md-5 cover-img" style="background-image: url('img/<%=bean.getNome()%>.jpg');"></div>
	  				<div class="col-md-7"  style="background-color: white; border-radius: 0px 30px 30px 0px;  border: 1px solid rgba(0,0,0,.125); padding: 22px;">
	  					<form name="aggiornattivita" method="post" action="AdminControl?tipo=attivita&action=update" onSubmit="">
	  						<div class="form-floating" style="margin-bottom: 12px;">
								<input type="text" class="form-control" id="nome" name="nome" value="<%=bean.getNome()%>">
								<label for="nome">Nome attività</label>
							</div>
							<div class="row">
								<div class="col">
									<div class="form-floating" style="margin-bottom: 12px;">
										<input type="text" class="form-control" id="idattivita" name="idattivita" disabled="disabled" value="<%=bean.getId_attivita()%>">
										<label for="nome">ID Attività</label>
									</div>
								</div>
								<div class="col">
									<div class="form-floating" style="margin-bottom: 12px;">
										<select class="form-select" name="categoria" id="categoria" aria-label="Seleziona categoria">
											<%if(bean.getCategoria().equals("Escursione")) {%><option value="Escursione" selected="selected">Escursione</option>
			 					 			<%} else %> <option value="Escursione">Escursione</option>
			 					 			<%if(bean.getCategoria().equals("Visita guidata")) {%><option value="Visita guidata" selected="selected">Visita guidata</option>
			 					 			<%}else %> <option value="Visita guidata">Visita guidata</option>
			 					 			<%if(bean.getCategoria().equals("Fattoria didattica")) {%><option value="Fattoria didattica" selected="selected">Fattoria didattica</option>
			 					 			<%}else %> <option value="Fattoria didattica">Fattoria didattica</option>
			 					 			<%if(bean.getCategoria().equals("Balneazione")) {%><option value="Balneazione" selected="selected">Balneazione</option>
			 					 			<%}else %> <option value="Balneazione">Balneazione</option>
			 					 			<%if(bean.getCategoria().equals("Ristoro")) {%><option value="Ristoro" selected="selected">Ristoro</option>
			 					 			<%}else %> <option value="Ristoro">Ristoro</option>
				 				 		</select>
				 				 		<label for="categoria">Categoria</label>
				 					</div>
			 					</div>
		 					</div>
		 					<div class="form-floating" style="margin-bottom: 12px;">
								<input type="text" class="form-control" name="descrizioneAttività" id="descrizioneAttività"  value="<%=bean.getDescrizione() %>">
								<label for="descrizioneAttività">Descrizione</label>
							</div>
							<div class="row">
								<div class="col">
									<div class="form-floating" style="margin-bottom: 12px;">
										<input type="number" class="form-control" name="numeroParticipanti" id="numeroParticipanti"  value="<%=bean.getMax_persone() %>">
										<label for="numeroParticipanti">Numero massimo di partecipanti</label>
									</div>
								</div>
								<div class="col">
									<div class="form-floating" style="margin-bottom: 12px;">
										<input type="number" class="form-control" name="prezzoAttività" id="prezzoAttività"  value="<%=bean.getPrezzo() %>">
										<label for="prezzoAttività">Prezzo</label>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col">
									<p class="text-center"><button type="submit" class="btn btn-outline-success">
										<svg xmlns="http://www.w3.org/2000/svg" style="margin-top: -3px;" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
										  <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5L13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175l-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
										</svg> Modifica
									</button></p>
								</div>
								<div class="col">
									<p class="text-center"><button type="button" class="btn btn-outline-danger" onclick="window.location.href='./AdminControl?tipo=attivita&action=rimuovi&id=<%=bean.getId_attivita()%>'">
										<svg xmlns="http://www.w3.org/2000/svg" style="margin-top: -3px;" width="16" height="16" fill="currentColor" class="bi bi-x-octagon" viewBox="0 0 16 16">
	  										<path d="M4.54.146A.5.5 0 0 1 4.893 0h6.214a.5.5 0 0 1 .353.146l4.394 4.394a.5.5 0 0 1 .146.353v6.214a.5.5 0 0 1-.146.353l-4.394 4.394a.5.5 0 0 1-.353.146H4.893a.5.5 0 0 1-.353-.146L.146 11.46A.5.5 0 0 1 0 11.107V4.893a.5.5 0 0 1 .146-.353L4.54.146zM5.1 1L1 5.1v5.8L5.1 15h5.8l4.1-4.1V5.1L10.9 1H5.1z"/>
	  										<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
										</svg> Elimina
									</button></p>
								</div>
								<div class="col"><p class="text-center">
		  							<button class="btn btn-outline-info" style="margin-top: -3px;" type="button" data-bs-toggle="collapse" data-bs-target="#collapse<%=bean.getId_attivita() %>" aria-expanded="false" aria-controls="collapseExample">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
											<path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V4.5z"/>
										</svg> Calendario
									</button>
								</div>
							</div>
						</form>
						</div>
						
					
						
						<div class="collapse" id="collapse<%=bean.getId_attivita() %>">
								<%
								CalendarioModelDM calendarioModelDM = new CalendarioModelDM();
								Collection<?> calendario = (Collection<?>) calendarioModelDM.doRetrieveByIdAttivita(bean.getId_attivita());
								if(calendario != null && calendario.size() > 0) {
									Iterator<?> iterator2 = calendario.iterator();
									while(iterator2.hasNext()) {
										Calendario cal = (Calendario) iterator2.next();
								%>
										<div class="card card-body">
	    									<div class="row">
	    										<div class="col"><p class="text-center"><%=cal.getDate() %></div>
	    										<div class="col"><p class="text-center"><%=cal.getOra()%></div>
	    										<div class="col">
	    											<p class="text-center">
	    												<a class="btn btn-link" style="color:red; text-decoration: none;" href="">
	  														<svg xmlns="http://www.w3.org/2000/svg" style="margin-top: -3px;" width="16" height="16" fill="currentColor" class="bi bi-x-octagon" viewBox="0 0 16 16">
	  															<path d="M4.54.146A.5.5 0 0 1 4.893 0h6.214a.5.5 0 0 1 .353.146l4.394 4.394a.5.5 0 0 1 .146.353v6.214a.5.5 0 0 1-.146.353l-4.394 4.394a.5.5 0 0 1-.353.146H4.893a.5.5 0 0 1-.353-.146L.146 11.46A.5.5 0 0 1 0 11.107V4.893a.5.5 0 0 1 .146-.353L4.54.146zM5.1 1L1 5.1v5.8L5.1 15h5.8l4.1-4.1V5.1L10.9 1H5.1z"/>
	  															<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
															</svg> Elimina
														</a>
	    											</p>
	    										</div>
	    									</div>	
										</div>
								<%
									}
								} else { %>
	  								<p>Non ci sono date disponibili</p>
	  							<%
	  							} %>
	    				</div>
	    			</div>
    		</div>
			<% 	}
		} else {
		%>
			<p>Non ci sono attività</p>
		<%} %>

		<!-- Bootstrap - JavaScript -->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
			crossorigin="anonymous">
		</script>
	</body>
</html>
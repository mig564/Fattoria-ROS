
function select_activity (name) {
	
	 document.getElementById('esc').style.backgroundColor = "#0f0";
}


function showAggiungiAttivita() {
	if(document.aggiungiattivita.style.display == "none") {
		document.aggiungiattivita.style.display="block";
		document.getElementById("btnAggiungi").value="Comprimi";
	} else {
		document.aggiungiattivita.style.display="none";
		document.getElementById("btnAggiungi").value="Aggiungi una nuova attività";
	}
}

function checkAttivita() {
	var part = document.aggiungiattivita.partecipanti;
	var prez = document.aggiungiattivita.prezzo;
	if(checkPartecipanti(part)) {
		if(checkPrezzo(prez)) {
			if(checkOrario()) {
				if(checkGiorni()) {
					if(checkMesi()) {
						return true;
					}
				}
			}
		}
	}
	return false;
}

function checkPartecipanti(part) {
	if(part.value > 0) {
		document.getElementById("errorPartecipanti").innerHTML = "";
		document.getElementById("errorPartecipanti").style.dislay = "none";
		document.aggiungiattivita.partecipanti.style.border = "1px solid green";
		return true;
	} else {
		document.getElementById("errorPartecipanti").innerHTML = "Inserisci un numero di partecipanti maggiore di zero.";
		document.getElementById("errorPartecipanti").style.color = "red";
		document.aggiungiattivita.partecipanti.style.border = "1px solid red";
		return false;
	}
}

function checkPrezzo(prezzo) {
	if(prezzo.value > 0) {
		document.getElementById("errorPrezzo").innerHTML = "";
		document.getElementById("errorPrezzo").style.dislay = "none";
		document.aggiungiattivita.prezzo.style.border = "1px solid green";
		return true;
	} else {
		document.getElementById("errorPrezzo").innerHTML = "Inserisci un prezzo maggiore di zero.";
		document.getElementById("errorPrezzo").style.color = "red";
		document.aggiungiattivita.prezzo.style.border = "1px solid red";
		return false;
	}
}

function checkOrario() {
	var ora1 = document.getElementById("checkOrario9");
	var orario1 = ora1.checked;
	var ora2 = document.getElementById("checkOrario10");
	var orario2 = ora2.checked;
	var ora3 = document.getElementById("checkOrario12");
	var orario3 = ora3.checked;
	var ora4 = document.getElementById("checkOrario14");
	var orario4 = ora4.checked;
	var ora5 = document.getElementById("checkOrario15");
	var orario5 = ora5.checked;
	var ora6 = document.getElementById("checkOrario18");
	var orario6 = ora6.checked;
	if(orario1 || orario2 || orario3 || orario4 || orario5 || orario6) {
		document.getElementById("errorOrario").innerHTML = "";
		document.getElementById("errorOrario").style.dislay = "none";
		return true;
	} else {
		document.getElementById("errorOrario").innerHTML = "Seleziona un orario.";
		document.getElementById("errorOrario").style.color = "red";
		return false;
	}
}

function checkGiorni() {
	var gio1 = document.getElementById("checkGiornoLunedi");
	var giorno1 = gio1.checked;
	var gio2 = document.getElementById("checkGiornoMartedi");
	var giorno2 = gio2.checked;
	var gio3 = document.getElementById("checkGiornoMercoledi");
	var giorno3 = gio3.checked;
	var gio4 = document.getElementById("checkGiornoGiovedi");
	var giorno4 = gio4.checked;
	var gio5 = document.getElementById("checkGiornoVenerdi");
	var giorno5 = gio5.checked;
	var gio6 = document.getElementById("checkGiornoSabato");
	var giorno6 = gio6.checked;
	var gio7 = document.getElementById("checkGiornoDomenica");
	var giorno7 = gio7.checked;
	if(giorno1 || giorno2 || giorno3 || giorno4 || giorno5 || giorno6 || giorno7) {
		document.getElementById("errorGiorno").innerHTML = "";
		document.getElementById("errorGiorno").style.dislay = "none";
		return true;
	} else {
		document.getElementById("errorGiorno").innerHTML = "Seleziona un giorno.";
		document.getElementById("errorGiorno").style.color = "red";
		return false;
	}
}

function checkMesi() {
	var me1 = document.getElementById("checkMeseGennaio");
	var mese1 = me1.checked;
	var me2 = document.getElementById("checkMeseFebbraio");
	var mese2 = me2.checked;
	var me3 = document.getElementById("checkMeseMarzo");
	var mese3 = me3.checked;
	var me4 = document.getElementById("checkMeseAprile");
	var mese4 = me4.checked;
	var me5 = document.getElementById("checkMeseMaggio");
	var mese5 = me5.checked;
	var me6 = document.getElementById("checkMeseGiugno");
	var mese6 = me6.checked;
	var me7 = document.getElementById("checkMeseLuglio");
	var mese7 = me7.checked;
	var me8 = document.getElementById("checkMeseAgosto");
	var mese8 = me8.checked;
	var me9 = document.getElementById("checkMeseSettembre");
	var mese9 = me9.checked;
	var me10 = document.getElementById("checkMeseOttobre");
	var mese10 = me10.checked;
	var me11 = document.getElementById("checkMeseNovembre");
	var mese11 = me11.checked;
	var me12 = document.getElementById("checkMeseDicembre");
	var mese12 = me12.checked;
	if(mese1 || mese2 || mese3 || mese4 || mese5 || mese6 || mese7 || mese8 || mese9 || mese10 || mese11 || mese12) {
		document.getElementById("errorMese").innerHTML = "";
		document.getElementById("errorMese").style.dislay = "none";
		return true;
	} else {
		document.getElementById("errorMese").innerHTML = "Seleziona un mese.";
		document.getElementById("errorMese").style.color = "red";
		return false;
	}
}
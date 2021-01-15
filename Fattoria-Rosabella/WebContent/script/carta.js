/* FUNZIONA PER MOSTRARE FORM */
function showFormAggiungiCarta() {
	if(document.aggiungicarta.style.display == "block") {
		document.aggiungicarta.style.display="none";
	} else document.aggiungicarta.style.display="block";
	
}

function showCarteDiCredito() {
	document.getElementById("carte").style.display = "block";
	document.getElementById("procedi").style.display = "block";
}

function removeCarteDiCredito() {
	document.getElementById("carte").style.display = "none";
	document.getElementById("procedi").style.display = "block";
}
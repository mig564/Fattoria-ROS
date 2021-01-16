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

function checkCarta() {
	var numero = document.aggiungicarta.numero;
	
}

function checkNumero(numero) {
	if(numero.lenght() != 16) {
		$("#errorNumero").text("Il numero di carta inserito non rispetta il formato.");
		document.getElementById("errorPassReg").style.color = "red";
		document.registrazione.password.style.border = "2px solid red";
		return false;
	} else {
		document.getElementById("errorNumero").style.display = "none";
		return true;
	}
}
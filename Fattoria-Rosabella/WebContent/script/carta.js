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
	var num = document.aggiungicarta.numero;
	var name = document.aggiungicarta.nome;
	var surname = document.aggiungicarta.cognome;
	var cvv = document.aggiungicarta.cvv;
	if(checkNumero(num)) {
		if(checkName(name)) {
			if(checkSurname(surname)) {
				if(checkCvv(cvv)) {
					return true;
				}
			}
		}
	}
	return false;
}



function checkNumero(numero) {
	var numbers = /^\d{16}$/;
	if(numero.value.match(numbers)) {
		document.getElementById("errorNumero").innerHTML = "";
		document.getElementById("errorNumero").style.dislay = "none";
		document.aggiungicarta.numero.style.border = "1px solid green";
		return true;
	} else {
		document.getElementById("errorNumero").innerHTML = "Numero carta inserito non valido.";
		document.getElementById("errorNumero").style.color = "red";
		document.aggiungicarta.numero.style.border = "1px solid red";
		return false;
	}
}

function checkName(name) {
	var letters = /^[A-Za-z]+$/;
	if(name.value.match(letters)) {
		document.getElementById("errorNome").innerHTML = "";
		document.getElementById("errorNome").style.dislay = "none";
		document.aggiungicarta.nome.style.border = "1px solid green";
		return true;
	} else {
		document.getElementById("errorNome").innerHTML = "Nome inserito non valido.";
		document.getElementById("errorNome").style.color = "red";
		document.aggiungicarta.nome.style.border = "1px solid red";
		return false;
	}
}

function checkSurname(surname) {
	var letters = /^[A-Za-z]+$/;
	if(surname.value.match(letters)) {
		document.getElementById("errorCognome").innerHTML = "";
		document.getElementById("errorCognome").style.dislay = "none";
		document.aggiungicarta.cognome.style.border = "1px solid green";
		return true;
	} else {
		document.getElementById("errorCogome").innerHTML = "Cognome inserito non valido.";
		document.getElementById("errorCognome").style.color = "red";
		document.aggiungicarta.nome.style.border = "1px solid red";
		return false;
	}
}

function checkCvv(cvv) {
	var numbers = /^\d{3}$/;;
	if(cvv.value.match(numbers)) {
		document.getElementById("errorCvv").innerHTML = "";
		document.getElementById("errorCvv").style.dislay = "none";
		document.aggiungicarta.cvv.style.border = "1px solid green";
		return true;
	} else {
		document.getElementById("errorCvv").innerHTML = "Il cvv inserito non è valido.";
		document.getElementById("errorCvv").style.color = "red";
		document.aggiungicarta.cvv.style.border = "1px solid red";
		return false;
	}
}


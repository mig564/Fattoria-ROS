/* FUNZIONE PER CAMBIARE FORM*/
function showFormRegister() {
	document.registrazione.style.display="block";
	document.login.style.display="none";
}

function showFormLogin() {
	document.registrazione.style.display="none";
	document.login.style.display="block";
}

//validazione form registrazione
function check_reg() {
	var name = document.registrazione.nome;
	
	var data_nascita = document.registrazione.data_nascita;
	var city = document.registrazione.citta;
	var email = document.registrazione.email;
	var password = document.registrazione.password;
	var double_password = document.registrazione.secondaPassword;
	
	if(chekName(name)) {
		if(chekCity(city)) {
			if (validateEmail(email)) {
				if (check_password(password, double_password)) return true;
			}
		}
	}
	return false;
}

function chekName(name) {
	var letters = /^[A-Za-z]+$/;
	if(name.value.match(letters)) {
		document.getElementById("errorNome").innerHTML = "";
		document.getElementById("errorNome").style.dislay = "none";
		document.registrazione.nome.style.border = "1px solid green";
		return true;
	} else {
		document.getElementById("errorNome").innerHTML = "Nome inserito non valido.";
		document.getElementById("errorNome").style.color = "red";
		document.registrazione.nome.style.border = "1px solid red";
		return false;
	}
}

function chekSurname() {
	var surname = document.registrazione.cognome;
	var chars = /^[A-Za-z]+$/;
	if(surname.value.match(chars)) {
		document.getElementById("errorCognome").innerHTML = "";
		document.getElementById("errorCognome").style.dislay = "none";
		document.registrazione.cognome.style.border = "1px solid green";
		return true;
	} else {
		document.getElementById("errorCogome").innerHTML = "Cognome inserito non valido.";
		document.getElementById("errorCognome").style.color = "red";
		document.registrazione.cognome.style.border = "1px solid red";
		return false;
	}
}

function data_nascita(data_nascita) {
	var today = new Date();
	var dd = String(today.getDate()).padStart(2, '0');
	var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
	var yyyy = today.getFullYear();

	today = mm + '/' + dd + '/' + yyyy;
	if (data_nascita < today) {
		document.getElementById("errorData").innerHTML = "";
		document.getElementById("errorData").style.dislay = "none";
		document.registrazione.data_nascita.style.border = "1px solid green";
		return true;
	} else {
		document.getElementById("errorData").innerHTML = "Non puoi essere nato nel futuro.";
		document.getElementById("errorData").style.color = "red";
		document.registrazione.data_nascita.style.border = "1px solid red";
		return false;
	}
}

function chekCity(city) {
	var letters = /^[A-Za-z]+$/;
	if(city.value.match(letters)) {
		document.getElementById("errorCitta").innerHTML = "";
		document.getElementById("errorCitta").style.dislay = "none";
		document.registrazione.citta.style.border = "1px solid green";
		return true;
	} else {
		document.getElementById("errorCitta").innerHTML = "Citta' inserita non valida.";
		document.getElementById("errorCitta").style.color = "red";
		document.registrazione.citta.style.border = "1px solid red";
		return false;
	}
}

function validateEmail(email) {
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (email.value.match(mailformat)) {
		document.getElementById("errorEmail").innerHTML = "";
		document.getElementById("errorEmail").style.dislay = "none";
		document.registrazione.email.style.border = "1px solid green";
		return true;
	} else {
		document.getElementById("errorEmail").innerHTML = "Email inserita non valida.";
		document.getElementById("errorEmail").style.color = "red";
		document.registrazione.email.style.border = "1px solid red";
		email.focus();
		return false;
	}
}

function check_password(password, psw_repeat) {
	var paswd = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;
	if(password.value.match(paswd) && password.value.length >= 6 && password.value.length <= 15) {
		if (password.value == psw_repeat.value) {
			document.getElementById("errorPassReg").innerHTML = "";
			document.getElementById("errorRepeatPass").innerHTML = "";
			document.getElementById("errorPassReg").style.dislay = "none";
			document.getElementById("errorRepeatPass").style.dislay = "none";
			document.registrazione.password.style.border = "1px solid green";
			document.registrazione.secondaPassword.style.border = "1px solid green";
			return true;
		} else {
			document.getElementById("errorRepeatPass").innerHTML = "Le password inserite non corrispondono.";
			document.getElementById("errorRepeatPass").style.color = "red";
			document.registrazione.password.style.border = "1px solid red";
			document.registrazione.secondaPassword.style.border = "1px solid red";
			return false;
		}
	} else {
			document.getElementById("errorRepeatPass").innerHTML = "";
			document.getElementById("errorRepeatPass").style.dislay = "none";
			document.getElementById("errorPassReg").innerHTML = "La password scelta non rispetta il formato: lunghezza copresa tra 6 e 15, almeno un carattera maiscuolo, uno minuscolo, un numero e un carattere speciale.";
			document.getElementById("errorPassReg").style.color = "red";
			document.registrazione.password.style.border = "1px solid red";
			document.registrazione.secondaPassword.style.border = "1px solid red";
		return false;
	}
}


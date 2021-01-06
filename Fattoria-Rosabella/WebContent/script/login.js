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
	var surname = document.registrazione.cognome;
	var password = document.registrazione.password;
	var email = document.registrazione.email;
	var double_password = document.registrazione.secondaPassword;
	var data_nascita = document.registrazione.data_nascita;
	var indirizzo = document.registrazione.indirizzo;
	var city = document.registrazione.citta;
	if(chekName(name)) {
		if(chekSurname(surname)) {
			if(chekCity(city)) {
				if (validateEmail(email)) {
					if (check_password(password, double_password)) {
						if (data_nascita(data_nascita)) {
							return true;
						}
					}
				}
			}
		}
	}
	return false;
}

function validateEmail(email) {
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (email.value.match(mailformat)) {
		return true;
	} else {
		alert("hai inserito un indirizzo email non valido!");
		email.focus();
		return false;
	}
}

function check_password(password, psw_repeat) {
	var paswd = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;
	if(password.value.match(paswd) && password.value.length >= 6 && password.value.length <= 15) {
		if (password.value == psw_repeat.value) {
			document.registrazione.psw_repeat.style.border = "1px solid #90A4AE";
			document.registrazione.password.style.border = "1px solid #90A4AE";
			document.getElementById("errorRepeatPass").innerHTML = "";
			document.getElementById("errorPassReg").innerHTML = "";
			return true;
		} else {
			document.getElementById("errorPassReg").innerHTML = "";
			document.registrazione.password.style.border = "1px solid #90A4AE";
			document.registrazione.psw_repeat.style.border = "2px solid red";
			document.getElementById("errorRepeatPass").innerHTML = "Le due password non corrispndono";
			return false;
		}
	} else {
		document.registrazione.psw_repeat.style.border = "1px solid #90A4AE";
		document.registrazione.password.style.border = "2px solid red";
		document.getElementById("errorPassReg").innerHTML = "La password deve avere da 6 a 15 caratteri, di cui almeno un carattere maiuscolo, un numero e un carattere speciale";
		return false;
	}
}

function chekName(name) {
	var letters = /^[A-Za-z]+$/;
	if(name.value.match(letters)) {
		return true;
	} else {
		alert("hai inserito un indirizzo nome non valido!");
		name.focus();
		return false;
	}
}

function chekSurname(surname) {
	var letters = /^[A-Za-z]+$/;
	if(surname.value.match(letters)) {
		return true;
	} else {
		alert("hai inserito un cognome nome non valido!");
		surname.focus();
		return false;
	}
}

function chekCity(city) {
	var letters = /^[A-Za-z]+$/;
	if(city.value.match(letters)) {
		return true;
	} else {
		alert("hai inserito un cognome nome non valido!");
		city.focus();
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
		return true;
	} else {
		alert("non puoi nascere nel futuro ahahahaha");
		return false;
	}
}
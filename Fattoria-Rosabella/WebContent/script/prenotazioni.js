
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


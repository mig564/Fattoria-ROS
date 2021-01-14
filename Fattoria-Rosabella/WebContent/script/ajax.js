function getReadyStateHandler(req) {
	return function() {
		if (req.readyState == 1) {
			console.log("Server connection");
		} else if ( req.readyState == 2 ) {
			console.log("Send request");
		} else if ( req.readyState == 3 ) {
				console.log("Receive response");
		} else if (req.readyState == 4) {
			console.log("Request finished and response is ready");
			if (req.status == 200 || req.status == 304) {
				console.log("Send data to the handler");
			} else {
				console.log("Response error "+ req.status + " " + req.statusText);
			}
		}
	};
}

function ajaxCall(date, id) {
	var ora = document.forms["selezioneAttivita"]["ora"].value
	var partecipanti = document.forms["selezioneAttivita"]["partecipanti"].value
	
	var req = xhr = new XMLHttpRequest();
	console.log("Get XML http request");
	
	req.onreadystatechange = getReadyStateHandler(req);
	
	req.open('POST', 'CarrelloAjax', true);
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	console.log("Open and send request");
	req.send("date=" + date +"&id=" + id +"&ora=" + ora + "&partecipanti=" + partecipanti);
}

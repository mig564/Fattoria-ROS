<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Area Privata</title>
	
</head>
<body>
	
	<form action="LoginAdmin" method="post">
	<div class="contenitoreForm">
		<h1>Login</h1>
		<div class="containerForm">
			<div class="containerForm-column-25">
				<label for="email" class="labelItem"><b>Email</b></label> 
			</div>
			<div class="containerForm-column-75">
				<input id="email" type="text" name="email" required> 
				
			</div>
			<div class="containerForm-column-25">
				<label for="password" class="labelItem"><b>Password</b></label>
			</div>
			<div class="containerForm-column-75">
				<input type="password" name="password" id="password" required>
			</div>
			<div class="containerForm-column-100">
				<p><input type="submit" name="submit" value="Login"></p>
			</div>
		</div>
	</div>
	</form>
	
</body>
</html>

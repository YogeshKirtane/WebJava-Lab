<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<div class="container"><br><br>
		<form action="Login" method="post">
			<div>
				<label>Enter Your User Name</label>
				<input type="text" name="username" placeholder="User Name"> 
			</div>
			<br><br>
			<div>
				<label>Enter Your Password</label>
				<input type="password" name="password" placeholder="User Password"> 
			</div>
			<br><br>
			<input type="submit" value="LOGIN" name="btnLogin">
		</form>
	</div>
</body>
</html>

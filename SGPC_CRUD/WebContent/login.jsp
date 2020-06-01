<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/site.css">

<style type="text/css">
html, body {
	font-family: Verdana, sans-serif;
	font-size: 12px;
	line-height: 1.5
}

html {
	overflow-x: hidden
}

body {
	background-color: #9E9E9E;
}

.btn-login {
	width: 100px;
	background-color: #85adad;
	color: white;
	padding: 14px 20px;
	margin: 1px 0;
	border: none;
	border-radius: 3px;
	cursor: pointer;
	margin-left: 30%;
}

.btn-login:hover {
	background-color: #45a049;
}

.div-login {
	width: 300px;
	height: 230px;
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
	margin-left: 35%;
	margin-top: 150px;
}

.div-error {
	width: 300px;
	height: 1px;
	border-radius: 5px;
	background-color: white;
	margin-left: 35%;
	padding: 20px;
	margin-top: 4px;
}

.p-login {
	margin-top: -10px;
}

.p-error-login {
	margin-left: 25%;
	margin-top: -10px;
	color: red;
}

.input-login {
	padding: 4px;
	margin: 3px 0;
	font-size: 15px;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 1px;
	box-sizing: border-box;
	margin-left: 30%;
}

.lbl-login {
	margin-left: 30%;
}
</style>
<title></title>
</head>
<body>
	<div class="div-login">
		<p class="p-login">Login</p>

		<form action="autentica" accept-charset="UTF-8" method="post">

			<label class="lbl-login">Usuario</label><br /> <input type="text"
				class="input-login" name="usuario" style="width: 150px"><br />

			<label class="lbl-login">Senha</label><br /> <input type="password"
				class="input-login" name="senha" style="width: 150px"><br />
			<br /> <input type="submit" class="btn-login" value="Entrar">
		</form>

	</div>


	<c:if test="${not empty login_erro}">

		<div class="div-error">
			<p class="p-error-login">${login_erro}!</p>
		</div>

	</c:if>


</body>
<%
	session.removeAttribute("login_erro");
%>
</html>
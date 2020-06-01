<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/site.css">
<title></title>
</head>
<body>
	<jsp:include page="home.jsp" />

	<form action="salva-cliente" method="post">

		<div class="div-externa-novo-cliente">
			<p class="p-novo-cliente">Cadastro de Clientes</p>

			<div class="div-interna-novo-cliente">


				<table>
					<tr>
						<td>Nome</td>
						<td><input type="text" class="input-novo-cliente" name="nomeClie"
							autocomplete="on" required="required" style="width: 300px"></td>
					</tr>

					<tr>
						<td>Sobrenome</td>
						<td><input type="text" class="input-novo-cliente" name="sobreClie"
							autocomplete="on" required="required" style="width: 300px"></td>
					</tr>

					<tr>
						<td>Cpf</td>
						<td><input type="text" class="input-novo-cliente" name="cpfClie" autocomplete="on" required="required" style="width: 134px">	
					</tr>

					<tr>
						<td>Data Nascimento</td>
						<td><input type="date" class="input-novo-cliente"
							name="dataNascClie" autocomplete="on" required="required"
							style="width: 130px"> 
					</tr>

					<tr>
						<td>Localidade</td>
						<td><input type="text" class="input-novo-cliente"
							name="localClie" autocomplete="on" required="required"
							style="width: 300px"></td>
					</tr>

				</table>

			</div>
			<input type="submit" class="btn-novo-cliente" value="Gravar">
			<input type="reset" class="btn-novo-cliente" value="Cancelar">

		</div>
	</form>
</body>
</html>
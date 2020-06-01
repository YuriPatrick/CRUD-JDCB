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
	<form action="update-cliente" method="post">
		<div class="div-externa-update-cliente">
			<p class="p-update-cliente">Atualização de Clientes</p>
			<div class="div-interna-update-cliente">


				<table>
					<tr>
						<td>Id</td>
						<td><input type="text" class="input-update-cliente" name="idClie" readonly="readonly" value="${cliente.id}" style="width: 300px"></td>
					</tr>
					<tr>
						<td>Nome</td>
						<td><input type="text" class="input-update-cliente"	name="nomeClie" autocomplete="on" value="${cliente.nome}" required="required" style="width: 300px"></td>
					</tr>
					
					<tr>
						<td>Sobrenome</td>
						<td><input type="text" class="input-update-cliente"	name="sobreClie" autocomplete="on" value="${cliente.sobrenome}" required="required" style="width: 300px"></td>
					</tr>

					<tr>
						<td>Cpf</td>
						<td><input type="text" class="input-update-cliente" name="cpfClie" autocomplete="on" value="${cliente.cpf}" required="required" style="width: 134px"></td> 
					</tr>

					<tr>
						<td>Data Nascimento</td>
						<td><input type="text" class="input-update-cliente" name="dataNascClie" autocomplete="on" value="${cliente.dataNascimento}" required="required" style="width: 130px"> 
					</tr>

					<tr>
						<td>Localidade</td>
						<td><input type="text" class="input-update-cliente" name="localClie" autocomplete="on" value="${cliente.localidade}" required="required" style="width: 300px"></td>
					</tr>

				</table>

			</div>
			<input type="submit" class="btn-updatecliente" value="Gravar">

		</div>
	</form>
</body>
</html>
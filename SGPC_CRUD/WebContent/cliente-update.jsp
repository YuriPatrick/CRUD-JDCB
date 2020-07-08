<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="stylesheet" type="text/css" href="css/site.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			var $campoCPF = $("#cpfClie");
			$campoCPF.mask('000.000.000-00', {
				reverse : true
			});
		});
	
		function limparMensagem() {
			document.getElementById('p-mensagem-sucesso').innerHTML = '';
		}
	</script>
	
	<style type="text/css">
		.div-externa-update-cliente {
			position: absolute;
			width: 490px;
			height: 470px;
			border-radius: 5px;
			background-color: #E8E8E8;
			padding: 20px;
			border-radius: 20px;
			margin: 45px -900px;
		}
		
		.div-interna-update-cliente {
			position: absolute;
			width: 450px;
			height: 350px;
			border-radius: 5px;
			background-color: #f2f2f2;
			padding: 15px;
		}
	</style>
	
<title>Atualizar Cliente</title>

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
							<td><input type="text" class="input-update-cliente"
								id="idClie" name="idClie" readonly="readonly"
								value="${cliente.id}" style="width: 300px"></td>
						</tr>
						<tr>
							<td>Nome</td>
							<td><input type="text" class="input-update-cliente"
								id="nomeClie" name="nomeClie" autocomplete="on"
								value="${cliente.nome}" required="required" style="width: 300px"></td>
						</tr>
	
						<tr>
							<td>Sobrenome</td>
							<td><input type="text" class="input-update-cliente"
								id="sobreClie" name="sobreClie" autocomplete="on"
								value="${cliente.sobrenome}" required="required"
								style="width: 300px"></td>
						</tr>
	
						<tr>
							<td>CPF</td>
							<td><input type="text" class="input-update-cliente"
								id="cpfClie" name="cpfClie" autocomplete="on"
								value="${cliente.cpf}" required="required" style="width: 300px"></td>
						</tr>
	
						<tr>
							<td>Data Nascimento</td>
							<td><input type="text" class="input-update-cliente"
								id="dataNascClie" name="dataNascClie" autocomplete="on"
								value="${cliente.dataNascimento}" required="required"
								style="width: 300px">
						</tr>
	
						<tr>
							<td>Localidade</td>
							<td><input type="text" class="input-update-cliente"
								id="localClie" name="localClie" autocomplete="on"
								value="${cliente.localidade}" required="required"
								style="width: 300px"></td>
						</tr>
	
					</table>

				<input type="submit" class="btn-updatecliente" id="gravar"
					value="Gravar">
			</div>
		</div>
	</form>
</body>
</html>
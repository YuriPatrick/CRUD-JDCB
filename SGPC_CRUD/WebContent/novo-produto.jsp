<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/site.css">
<script type="text/javascript" src="js/controle.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<title></title>
<style type="text/css">
.div-externa-novo-produto {
	position: absolute;
	width: 490px;
	height: 350px;
	border-radius: 5px;
	background-color: #E8E8E8;
	padding: 20px;
	border-radius: 20px;
	margin: 70px -900px;
}

.div-interna-novo-produto {
	position: absolute;
	width: 450px;
	height: 230px;
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 15px;
}
</style>

</head>
<body>
	<jsp:include page="home.jsp" />
	<form action="salva-produto" name="dados" method="post">

		<div class="div-externa-novo-produto">
			<p class="p-novo-produto">Cadastro de Produtos</p>
			<div class="div-interna-novo-produto">

				<table>
					<tr>
						<td>Nome</td>
						<td><input type="text" class="input-novo-produto" id="nomProd" name="nomProd" required="required" style="width: 315px"></td>
					</tr>

					<tr>
						<td>Descrição</td>
						<td><input type="text" class="input-novo-produto" id="descProd" name="descProd" required="required"
							style="width: 315px"></td>
					</tr>


					<tr>
						<td>Quantidade</td>
						<td><input type="number" class="input-novo-produto" id="qntProd" name="qntProd" value="0" required="required"
							style="width: 315px"></td>
					</tr>

					<tr>
						<td>Observação</td>
						<td><input type="text" class="input-novo-produto" id="obsProd" name="obsProd" required="required" style="width: 315px"></td>
					</tr>

				</table>

			
			<input type="submit" class="btn-novo-produto" id="gravar" value="Gravar"> 
			<input type="reset" class="btn-novo-produto" id="cancelar" value="Cancelar">
			
			</div>
			
		</div>

	</form>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

</body>
</html>
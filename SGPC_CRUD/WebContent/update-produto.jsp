<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/site.css">
<script type="text/javascript" src="js/controle.js"></script>
<title></title>
<style type="text/css">
.div-externa-update-produto {
	position: absolute;
	width: 490px;
	height: 410px;
	border-radius: 5px;
	background-color: #E8E8E8;
	padding: 20px;
	border-radius: 20px;
	margin: 70px -900px;
}

.div-interna-update-produto {
	position: absolute;
	width: 450px;
	height: 280px;
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 15px;
}
</style>
</head>
<body>
	<jsp:include page="home.jsp" />

	<form action="update-produto" name="dados" method="post">


		<div class="div-externa-update-produto">
			<p class="p-update-produto">Atualização do Produto</p>
			<div class="div-interna-update-produto">


				<table>
					<tr>
						<td>ID</td>
						<td><input type="text" class="input-update-produto"
							readonly="readonly" name="idProd" value="${produto.id}"
							style="width: 315px"></td>
					</tr>


					<tr>
						<td>Nome</td>
						<td><input type="text" class="input-update-produto"
							name="nomProd" value="${produto.nome}" required="required"
							style="width: 315px"></td>
					</tr>


					<tr>
						<td>Descrição</td>
						<td><input type="text" class="input-update-produto"
							name="descProd" value="${produto.descricao}" required="required"
							style="width: 315px"></td>
					</tr>
					<tr>
						<td>Quantidade</td>
						<td><input type="number" class="input-update-produto"
							name="qntProd" value="${produto.qnt}" required="required"
							style="width: 315px"></td>
					</tr>

					<tr>
						<td>Obs</td>
						<td><input type="text" class="input-update-produto"
							name="obsProd" value="${produto.obs}" required="required"
							style="width: 315px"></td>
					</tr>

				</table>

			
			<input type="submit" class="btn-update-produto" id="gravar" value="Gravar">
			</div>
		</div>
	</form>
</body>
</html>
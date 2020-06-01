<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/site.css">
<script type="text/javascript" src="js/controle.js"></script>
<title></title>
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
							style="width: 147px"></td>
					</tr>

					<tr>
						<td>Obs</td>
						<td><input type="text" class="input-update-produto"
							name="obsProd" value="${produto.obs}" required="required"
							style="width: 147px"></td>
					</tr>

				</table>

			</div>
			<input type="submit" class="btn-update-produto" value="Gravar">
			
		</div>
	</form>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="stylesheet" type="text/css" href="css/file3.css">
	<style type="text/css">
		.div-lista {
			position: absolute;
			width: 80%;
			height:300px;
			border-radius: 5px;
			background-color: #f2f2f2;
			padding: 20px;
			border-radius: 20px;
			margin: 165px 15px;
		}
	</style>

<title>Lista de Produto</title>

</head>
<body>
	
<jsp:include page="home.jsp" />
	<div class="div-lista">
		<section>

			<div class="tbl-header">


				<table>
					<thead>
						<tr>
							<th>ID</th>
							<th>Nome</th>
							<th>Descri��o</th>
							<th>Quantidade</th>
							<th>Obs</th>
							<th>Opera��es</th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="tbl-content">

				<table id="myTable">

					<tbody>
						<c:forEach var="produto" items="${produtos}">
							<tr class="header">
								<td>${produto.id}</td>
								<td>${produto.nome}</td>
								<td>${produto.descricao}</td>
								<td>${produto.qnt}</td>
								<td>${produto.obs}</td>
								
								<td style="width: 80px"><a href="<c:url value="/getId-produto?id=${produto.id}"/>">Alterar</a></td>
	
								<td style="width: 80px"><a href="<c:url value="/remove-produto?id=${produto.id}"/>"
									onclick="return confirm('Deseja realmente excluir o Produto')" id="ok">Excluir</a></td>
			
							</tr>
						</c:forEach>
				</table>
			</div>
		</section>
	</div>

</body>
</html>
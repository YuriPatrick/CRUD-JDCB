<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/file3.css">
<title>Lista de Clientes</title>
<style type="text/css">
.div-lista {
	position: absolute;
	width: 80%;
	height: 300px;
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
	border-radius: 20px;
	margin: 170px 15px;
}
</style>
</head>
<body>
	<jsp:include page="home.jsp" />
	<div class="div-lista">
		<section>

			<div class="tbl-header">


				<table>
					<thead>
						<tr>
							<th>Nome</th>
							<th>Sobrenome</th>
							<th>CPF</th>
							<th>Data Nascimento</th>
							<th>Localidade</th>
							<th>Operações</th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="tbl-content">

				<table id="myTable">

					<tbody>
						<c:forEach var="cliente" items="${clientes}">
							<tr>
								<td>${cliente.nome}</td>
								<td>${cliente.sobrenome}</td>
								<td>${cliente.cpf}</td>
								<td>${cliente.dataNascimento}</td>
								<td>${cliente.localidade}</td>

								<td style="width: 90px"><a
									href="<c:url value="/id-update-cliente?id=${cliente.id}"/>">Alterar</a></td>

								<td style="width: 90px"><a
									href="<c:url value="/remove-cliente?id=${cliente.id}"/>"
									onclick="return confirm('Deseja realmente excluir o Cliente')">Excluir</a></td>


							</tr>
						</c:forEach>
					</tbody>
				</table>
				<form action="exportar-clientes" name="dados" method="post">
					<input type="submit" id="exportar" class="btn-novo-produto"
						value="Exportar">
				</form>
			</div>
		</section>
	</div>

</body>
</html>

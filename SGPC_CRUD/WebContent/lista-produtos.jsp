<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/file.css">

<title></title>
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
						</tr>
					</thead>
				</table>
			</div>
			<div class="tbl-content">

				<table>
					<tbody>
						<c:forEach var="produto" items="${produtos}">
							<tr>
								<td>${produto.id}</td>
								<td>${produto.nome}</td>
								<td>${produto.descricao}</td>
								<td>${produto.qnt}</td>
								<td>${produto.obs}</td>

							</tr>
						</c:forEach>

					</tbody>
				</table>

			</div>
		</section>

		<form action="exporte-produtos" name="dados" method="post">
			<input type="submit" class="btn-novo-produto" value="Exportar">
		</form>

		<form action="importe-produtos" name="dados" method="post"
			enctype="multipart/form-data" style="margin: -50px 120px">

			Select a file to upload: <br /> 
			
			<input type="file" name="file" size="60" /> <br /> 
				<input type="submit" class="btn-novo-produto"
				value="Upload">

		</form>

	</div>
</body>
</html>
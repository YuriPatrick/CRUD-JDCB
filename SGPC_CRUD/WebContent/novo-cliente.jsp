<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/site.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
<style type="text/css">
.div-externa-novo-cliente {
	position: absolute;
	width: 490px;
	height: 410px;
	border-radius: 5px;
	background-color: #E8E8E8;
	padding: 20px;
	border-radius: 20px;
	margin: 60px -900px;
}

.div-interna-novo-cliente {
	position: absolute;
	width: 450px;
	height: 295px;
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 15px;
}
</style>

<script type="text/javascript">
    $(document).ready(function () { 
        var $seuCampoCpf = $("#cpfClie");
        $seuCampoCpf.mask('000.000.000-00', {reverse: true});
    });
</script>

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
						<td><input type="text" class="input-novo-cliente" id="nomeClie" name="nomeClie"
							autocomplete="on" required="required" style="width: 300px"></td>
					</tr>

					<tr>
						<td>Sobrenome</td>
						<td><input type="text" class="input-novo-cliente" id="sobreClie" name="sobreClie"
							autocomplete="on" required="required" style="width: 300px"></td>
					</tr>

					<tr>
						<td>CPF</td>
						<td><input type="text" class="input-novo-cliente" id="cpfClie" name="cpfClie" class="form-control cpf-mask" placeholder="Ex.: 000.000.000-00" autocomplete="on" required="required" style="width: 300px">	
					</tr>

					<tr>
						<td>Data de Nascimento</td>
						<td><input type="date" class="input-novo-cliente"
							id="dataNascClie" name="dataNascClie" autocomplete="on" required="required"
							style="width: 300px"> 
					</tr>

					<tr>
						<td>Localidade</td>
						<td><input type="text" class="input-novo-cliente"
							id="localClie" name="localClie" autocomplete="on" required="required"
							style="width: 300px"></td>
					</tr>

				</table>

			
			<input type="submit" class="btn-novo-cliente" id="gravar" value="Gravar">
			<input type="reset" class="btn-novo-cliente" value="Cancelar">
		  </div>
		</div>
	</form>
</body>
</html>
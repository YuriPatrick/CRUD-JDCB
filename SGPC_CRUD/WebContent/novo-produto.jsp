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
	 <jsp:include page="home.jsp"/>
	<form action="salva-produto" name="dados" method="post">
	
	<div class="div-externa-novo-produto">
	<p class="p-novo-produto">Cadastro de Produtos</p>
  <div class="div-interna-novo-produto">

     
	 <table>
		<tr>
			<td>Nome</td>
			<td><input type="text" class="input-novo-produto" name="nomProd" required="required" style="width:315px"></td>		
		</tr>
		
		<tr>
			<td>Descrição</td>
			<td><input type="text" class="input-novo-produto" name="descProd" required="required" style="width:315px"></td>		
		</tr>
		 

		<tr>
			<td>Quantidade</td>
			<td><input type="number" class="input-novo-produto" name="qntProd"  value="0" required="required" style="width:147px"></td>
		</tr>
		
		<tr>
			<td>Observação</td>
			<td><input type="text" class="input-novo-produto" name="obsProd" required="required" style="width:147px"></td>
		</tr>
 		 
	 </table>
     
  </div>
    <input type="submit" class="btn-novo-produto" value="Gravar">
	<input type="reset" class="btn-novo-produto" value="Cancelar">
 
</div>
 </form>
</body>
</html>
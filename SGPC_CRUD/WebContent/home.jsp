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

<ul>
  <li><a class="active" href="home.jsp">Home</a></li>
 
  <li class="dropdown">
    <a href="#" class="dropbtn">Clientes</a>
    <div class="dropdown-content">
      <a href="./novo-cliente">Novo Cliente</a>
      <a href="./all-clientes">Lista de Clientes</a>
    </div>
  </li>
  <li class="dropdown">
    <a href="#" class="dropbtn">Produtos</a>
    <div class="dropdown-content">
      <a href="./novo-produto">Novo Produto</a>
      <a href="./get-produtos">Todos Produtos</a>
      <a href="./alteracao-produtos">Alteração de Produtos</a>
	  <li style="float:right"><a class="active" href="./logof">Sair</a></li>
    </div>
  </li>
    
   
</ul>
</body>
</html>
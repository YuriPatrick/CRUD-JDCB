<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<style type="text/css">
.div-error {
	width:300px;
	height:1px;
    border-radius: 5px;
    background-color: white;
	margin-left:36%;
	padding: 20px;
	margin-top:-230px;
}
</style>

</head>
<body>

<!-- no additional media querie or css is required -->
<div class="container">
        <div class="row justify-content-center align-items-center" style="height:100vh">
            <div class="col-4">
                <div class="card">
                    <div class="card-body">
                        <form action="autentica" accept-charset="UTF-8" method="post">
                            <div class="form-group">
                                Usuario: <input type="text" class="form-control" name="usuario">
                            </div>
                            <div class="form-group">
                                Senha: <input type="password" class="form-control" name="senha">
                            </div>
                            <input type="submit" id="entrar" class="btn btn-primary" value="Entrar">
                            <button type="button" id="sendlogin" class="btn btn-primary">Cancelar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
     <c:if test="${not empty login_erro}">
  			
  			<div class="div-error">
  			<p class="p-error-login">
			${login_erro}!
			</p>
			</div>
			
		</c:if>
    
</body>
<%
	session.removeAttribute("login_erro");
%>

</html>

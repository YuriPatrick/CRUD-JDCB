function id(el) {
  return document.getElementById( el );
}
function total( un, qnt ) {
  return parseFloat(un.replace(',', '.'), 10) * parseFloat(qnt.replace(',', '.'), 10);
}
window.onload = function() {
  id('valor').addEventListener('keyup', function() {
    var result = total( this.value , id('quantidade').value );
    id('total').value = String(result.toFixed(2)).formatMoney();
  });

  id('quantidade').addEventListener('keyup', function(){
    var result = total( id('valor').value , this.value );
    id('total').value = String(result.toFixed(2)).formatMoney();
  });
}

String.prototype.formatMoney = function() {
  var v = this;

  if(v.indexOf('.') === -1) {
    v = v.replace(/([\d]+)/, "$1,00");
  }

  v = v.replace(/([\d]+)\.([\d]{1})$/, "$1,$20");
  v = v.replace(/([\d]+)\.([\d]{2})$/, "$1,$2");
  v = v.replace(/([\d]+)([\d]{3}),([\d]{2})$/, "$1.$2,$3");

  return v;
};
 

function SomenteNumero(e){
    var tecla=(window.event)?event.keyCode:e.which;   
    if((tecla>47 && tecla<58)) return true;
    else{
    	if (tecla==8 || tecla==0 || tecla ==44 || tecla ==46) return true;
	else  return false;
    }
}


function validaInput(){
	
	if (document.dados.fornecedor.value =="") {
		document.getElementById("lbl").innerHTML = "Fornecedor Invalido";
		document.formulario.fornecedor.focus();
		return false;
		
	} if (document.dado.descricao.value=="Selecione") {
		alert("Descrição invalida")
		document.formulario.descricao.focus();
		return false;
	} if (document.dado.descricao.value=="Selecione") {
		alert("Descrição invalida")
		document.formulario.descricao.focus();
		return false;
	} if (document.dado.descricao.value=="Selecione") {
		alert("Descrição invalida")
		document.formulario.descricao.focus();
		return false;
	} 

	return true;
	
}

document.getElementById("idProd").value = "1";
 



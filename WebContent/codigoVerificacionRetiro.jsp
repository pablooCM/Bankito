<!DOCTYPE html>
<html style="width: 644px; height: 993px; ">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"
	media="all">

<title>Bank-iTo</title>

<style>
html
{
	text-align: center;
}
body {
	margin: 20px;
	max-width: 800px;
	padding: 20px;
	background: url('img/bankito.png');	
    background-repeat: no-repeat;
    background-size: 430px 550px;	
	
}

.container {
	border: 2px solid #dedede;
	background-color: #f1f1f1;
	border-radius: 5px;
	padding: 10px;
	margin: 10px 0;
}

.darker {
	border-color: #ccc;
	background-color: #ddd;
}

.container::after {
	content: "";
	clear: both;
	display: table;
}

.container img {
	float: left;
	max-width: 60px;
	width: 100%;
	margin-right: 20px;
	border-radius: 50%;
}

.container img.right {
	float: right;
	margin-left: 20px;
	margin-right: 0;
}

.time-right {
	float: right;
	color: #aaa;
}

.time-left {
	float: left;
	color: #999;
}

</style>

</head>
<body style="width: 472px; height: 520px; ">
	<fieldset style="text-align: left; width: 381px; height: 541px">
		<legend style="width: 296px; ">Realizar retiro:</legend>
		<form action="ServletEnviarMensaje" method="post" style="width: 375px; height: 305px">
			<p style="width: 369px; height: 37px">
				<label for="cuenta" style="width: 143px;">Número de cuenta:</label>
				<input name="cuenta" type="text" id="cuenta" class="cuenta" style="width: 202px;">
			</p> 	
			<p style="width: 369px; height: 37px">
				<label for="pin" style="width: 143px;">Pin:</label>
				<input name="pin" type="text" id="pin" class="pin" style="width: 202px;">
			</p>	
			<input name="tipo" type="text" id="tipo" class="tipo" value="colones" style="text-align:center; width: 353px;">
			<div id="campo" style="text-align: center; width: 351px" >
			</div>			
			<br>
			<br>
			<div style="text-align: center; width: 358px" >
				<a href="Bank-iTo.jsp"> <input type="button" class="btn btn-info" value="Volver" style="width: 132px; height: 53px;"></a>
				<input id= "buttonCod" type="submit" class="btn btn-success" value="Enviar SMS con código de verificación." style="width: 300px; height: 53px;">				
			</div>
		</form>
	</fieldset>
	<script type="text/javascript">
		function agregarCampo()
        {
         	var div = document.getElementById("campo"); 
         	//Agregar botones por lugar       
         	var input = document.createElement("input");  
         	input.setAttribute("name", "codigo");
            input.setAttribute("type", "text");
            input.setAttribute("id", "codigo");
            input.setAttribute("class", "codigo");
            input.setAttribute("style", "width: 202px;");
            
            var label = document.createElement("label");
              
         	label.setAttribute("for", "codigo");
         	label.setAttribute("style", "width: 143px;");
         	
         	var text = document.createTextNode("Código de Verificación:");
         	
         	label.appendChild(text);
         	
         	div.appendChild(label);
            div.appendChild(input);
            
            var button = document.getElementById("buttonCod");
            button.setAttribute("disabled","none");
		}
	</script>
</body>
</html>
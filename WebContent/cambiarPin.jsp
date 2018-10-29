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
	margin: 40px;
	max-width: 800px;
	padding: 20px;
	background: url('img/bankito.png');	
    background-repeat: no-repeat;
    background-size: 500px 650px;	
	
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
	<fieldset style="text-align: left; width: 381px; height: 394px">
		<legend>Cambiar Pin:</legend>
		<form action="SERVLET" method="post" style="width: 375px; height: 339px">
			<p style="width: 369px; height: 37px">
				<label for="pinA" style="width: 143px;">Pin actual:</label>
				<input name="pinA" type="text" id="pinA" class="pinA" style="width: 202px;" value="El pin debe ser alfanumérico">
			</p> 				
			<p style="width: 369px; height: 37px">
				<label for="pin" style="width: 143px;">Pin:</label>
				<input name="pin" type="text" id="pin" class="pin" style="width: 202px;" value="El pin debe ser alfanumérico"> 				
			</p>
			<p>					
				<label for="nombre" style="width: 143px; height: 26px">Nombre dueño:</label> 
				<input name="nombre" type="text" id="nombre" class="nombre" style="width: 203px;">
			</p>
			<p>
				<label for="telefono" style="width: 144px;">Teléfono:</label> 
				<input name="telefono" type="text" id="telefono" class="telefono" style="width: 202px;">
			</p>
			<p>
				<label for="correo" style="width: 144px;">Correo Electrónico:</label> 
				<input name="correo" type="email" id="correo" class="correo" style="width: 203px; height: 24px">
			</p>					
			<p>
				<label for="montoInicial" style="width: 143px;">Monto Inicial:</label>
				<input name="montoInicial" type="number" id="montoInicial" class="carnet" style="width: 204px;">
			</p>
			<p style="text-align: center;" >
				<a href="login.jsp"> <input type="button" class="btn btn-info" value="Volver" style="width: 132px; height: 53px;"></a>
				<input type="submit" class="btn btn-warning" value="Registrar" style="width: 132px; height: 53px;">
			</p>
		</form>
	</fieldset>	
</body>
</html>
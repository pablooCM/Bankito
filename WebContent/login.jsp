<!DOCTYPE html>
<html style="width: 496px; height: 610px; ">
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
    background-size: 440px 570px;
	
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
<body style="width: 472px; height: 573px; ">
	<fieldset style=" text-align: left; width: 365px; height: 252px">
		<legend>Iniciar Sesión:</legend>
		<form action="SERVLET" method="post" style="width: 365px; height: 225px">
			<p style="height: 30px; width: 342px">
				<label for="correo" style="width: 153px;">Correo Electrónico:</label>
				<input name="correo" type="text" id="correo" class="correo" style="width: 173px;">
			</p> 				
			<p style="width: 348px; height: 37px">
				<label for="contrasenna" style="width: 153px;">Contraseña:</label>
				<input name="contrasenna" type="text" id="contrasenna" class="contrasenna" style="width: 175px;"> 				
			</p>
			<p style="text-align: center;" >
				<input type="submit" class="btn btn-success" value="Iniciar Sesión" style="width: 132px; height: 53px;">
			</p>
			<br><br><br>
			<p style="text-align: center;" >
				<a style="font-weight: bold;" href="">Registrar nueva cuenta.</a>
			</p>
		</form>
	</fieldset>	
</body>
</html>
	
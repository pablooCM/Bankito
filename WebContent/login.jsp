<!DOCTYPE html>
<html style="width: 624px; height: 339px">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>BANK-iTo</title>

<style>
body {
	margin: 0 auto;
	max-width: 800px;
	padding: 0 20px;
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

<body style="width: 695px; height: 350px">
	<h1 style="text-align: center">Bank-iTo</h1>
	 
	<div class="container darker" style="height: 270px; width: 645px">
		<div class="container" style="width: 607px;">
			<fieldset style="width: 543px;">
				<legend>Iniciar Sesión:
				<form action="ServletLogin" method="post" class="navbar-form navbar-right" style="width: 519px;">
					<p>
						<label>Correo Electrónico:</label>
						<input name="correo" type="email" id="correo" style="width: 207px;">
					</p>
					
					<p style="width: 495px; height: 65px">
						<label style="width: 131px;">Contraseña:</label> 
						<input name="contrasena" type="password" id="contrasena" style="width: 206px;">
						<input type="submit" class="btn btn-success" value="Iniciar Sesión" style="width: 132px; height: 45px;">
					</p>
				</form></legend>
				
			</fieldset>
		</div><br> 
			<a style="font-weight: bold;"href="registrarEstudiante.jsp">Registrar nueva cuenta.</a>
	</div>
</body>
</html>
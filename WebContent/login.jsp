<!DOCTYPE html>
<html style="width: 676px; height: 535px">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">

<style>
.bg { 
    /* The image used */
    background-image: url("/img/bankito.png");

    /* Full height */
    height: 10%; 

    /* Center and scale the image nicely */
 
    background-repeat: no-repeat;
    background-size: cover;
}
</style>

<title>BANK-iTo</title>
</head>
<body class = "bg" style="width: 571px; ">
	<div style="height: 501px; width: 606px">
		<div class="container" style="width: 559px;">
			<fieldset style="width: 543px;">
				<legend>Iniciar Sesión:</legend>
				<form action="ServletLogin" method="post"
					class="navbar-form navbar-right" style="width: 521px;">
					<p style="width: 403px;">
						<label>Correo Electrónico:</label> <input name="correo"
							type="email" id="correo" style="width: 207px;">
					</p>
					<p style="width: 495px; height: 55px">
						<label style="width: 131px;">Contraseña:</label> 
						<input name="contrasena" type="password" id="contrasena" style="width: 206px;">
						<input type="submit" class="btn btn-success" value="Iniciar Sesión"style="width: 132px; height: 45px;">
					</p>
				</form>
			</fieldset>
		</div>
		<a style="font-weight: bold;" href="registrarAdminProfe.jsp">Registrar
			Profesor o Administrativo</a><br> <a style="font-weight: bold;"
			href="registrarEstudiante.jsp">Registrar Estudiante</a>
	</div>
</body>
</html>
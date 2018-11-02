<!DOCTYPE html>
<html style="width: 577px; height: 855px; ">
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
<body style="width: 472px; height: 780px; ">
	<fieldset style="text-align: left; width: 381px; height: 394px">
		<legend style="width: 340px; ">Cambiar Correo Electrónico para notificaciones:</legend>
		<form action="SERVLET" method="post" style="width: 375px; height: 231px">					
			<p>
				<label for="correo" style="width: 144px;">Correo Electrónico:</label>
				<input name="correo" type="email" id="correo" class="correo" style="width: 203px; height: 24px">
			</p>
			<p style="width: 369px; height: 37px">
				<label for="password" style="width: 143px;">Contraseña:</label>
				<input name="password" type="password" id="password" class="password" style="width: 202px;"> 				
			</p>
			<p style="text-align: center; width: 361px" >
				<a href="Bank-iTo.jsp"> <input type="button" class="btn btn-info" value="Volver" style="width: 132px; height: 53px;"></a>
				<input type="submit" class="btn btn-warning" value="Actualizar" style="width: 132px; height: 53px;">
			</p>
		</form>
	</fieldset>	
</body>
</html>
<!DOCTYPE html>
<html style="width: 706px; height: 1064px">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"
	media="all">
<link rel="stylesheet" href="format.css">

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
	background-color: #f1f1f;
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
<body style="width: 485px; height: 555px; ">
	<fieldset style=" text-align: left; width: 381px; height: 394px">
		<legend style="width: 287px; ">Transferencia:</legend>
		<form action="SERVLET" method="post" style="width: 375px; height: 339px">
			<p>
				<label for="montoTransferir" style="width: 143px;">Monto a transferir:</label>  
				<input name="montoTransferir" type="number" id="montoTransferir" class="montoTransferir" style="width: 136px;">
				colones.		
			</p>	
					<p style="width: 369px; height: 37px">
					<label for="cuentaA" style="width: 143px;">Cuenta a acreditar:</label>
					<input name="cuentaA" type="text" id="cuentaA" class="cuentaA" style="width: 202px;">
			</p> 		
			<p style="text-align: center; width: 358px" >
				<a href="codigoVerificacionTransferencia.jsp"> <input type="button" class="btn btn-info" value="Volver" style="width: 132px; height: 53px;"></a>
				<input type="submit" class="btn btn-warning" value="Transeferir" style="width: 132px; height: 53px;">
			</p>
		</form>
	</fieldset>		
</body>
</html>
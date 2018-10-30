<!DOCTYPE html>
<html style="width: 558px; height: 182px">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<style>
.vertical-menu {
	width: 200px;
}

.vertical-menu a {
	background-color: #f1f1f;
	color: black;
	display: block;
	padding: 12px;
	text-decoration: none;
}

.vertical-menu a:hover {
	background-color: #ccc;
}

.vertical-menu a.active {
	background-color: #4CAF50;
	color: white;
}

html
{
	text-align: center;
}
body {
	margin: 30px;
	max-width: 800px;
	padding: 20px;
	background: url('img/bankito.png');	
    background-repeat: no-repeat;
    background-size: 430px 550px;	
    background-position: static;
	
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

<title>Bank-iTo</title>
</head>
<body style="width: 409px; height: 376px; ">
	<form action="SERVLET" method="post"  class="vertical-menu" style="width: 321px; height: 103px; visibility: visible; top: auto; left: auto; bottom: auto;">
		<a href="Bank-iTo.jsp" class="active" style="font-family: Arial, Helvetica, sans-serif;">Bank-iTo</a>
		<input type="submit" value="Consulta tipo de cambio de venta." style="border: 0; width: 264px; height: 53px;">
	</form>
	<form action="SERVLET" method="post" class="vertical-menu" style="width: 321px; height: 48px; visibility: visible; top: auto; left: auto; bottom: auto;">
		<input type="submit" value="Consulta tipo de cambio de compra." style="border: 0; width: 264px; height: 53px;">
	</form>
</body>
</html>
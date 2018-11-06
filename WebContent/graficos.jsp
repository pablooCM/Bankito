<!DOCTYPE html>  
<html style="width: 439px; height: 296px">  
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"  media="all">  
	<link rel="stylesheet" href="format.css">  
<title>Bank-iTo</title> 
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>  
<script type="text/javascript">  
    google.charts.load("current", {packages:["corechart"]});  
    google.charts.setOnLoadCallback(drawChart);  
    function drawChart() {  
	    var data = google.visualization.arrayToDataTable([  
			      ['Movimiento', 'Cantidad'],  
			      ['Retiros',  "+retiros+"],  
			      ['Depósitos', "+debitos+"],  
			      ['Transferencias', "+transferencias+"],  
			      ]); 
	 	var options = {  
		       title: 'Movimientos de la cuenta "+cuenta+"',  
		       is3D: true,  
			   slices: {0: {color: '"+retirosColor+"'}, 1:{color: '"+debitosColor+"'}, 2:{color: 'red'}
			   }
	 	}   
	    var chart = new google.visualization.PieChart(document.getElementById('movimientos'));  
		       chart.draw(data, options);  
	}  
</script>  
</head>  
<body style="width: 424px; height: 256px;">
<fieldset style=" text-align: left; width: 381px; height: 250px">
	<legend style="width: 287px; ">Gráfico:</legend>
	<div id="DATOS" style="background-color: #f1f1f1;width: 405px; height: 186px;"></div>
</fieldset>
</body>
</html>
package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaAccesoaDatos.BaseDatos;
import logicaDeNegocios.MD5;
import logicaIntegracion.EnviarMail;

/**
 * Servlet implementation class ServletGraficos
 */
@WebServlet("/ServletGraficos")
public class ServletGraficos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGraficos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cuenta = request.getParameter("cuenta").toString();
		String pin= request.getParameter("pin").toString();
		String debitosColor= request.getParameter("debitos").toString();
		String retirosColor= request.getParameter("retiros").toString();
		
		BaseDatos con = new BaseDatos();

		PrintWriter out = response.getWriter();	
		int cuentaInt = Integer.parseInt(cuenta);
		try 
		{
			if(con.selectEstatus(cuentaInt).equals("activa"))
			{
				try 
				{			        
					String pinEncriptado = MD5.Encriptar(pin);
			         
			        System.out.println("Verifica:"+pinEncriptado);
					
					int cuenta_consult = con.selectCuenta(cuenta, pinEncriptado);
			        
					if(cuenta_consult != 0)
					{	
						int transferencias = con.selectCantidadTransferencias(cuentaInt);
						int debitos = con.selectCantidadDebitos(cuentaInt);
						int retiros = con.selectCantidadRetiros(cuentaInt);
						double montoDeb = con.selectMontoDebitos(cuentaInt);
						double montoCre = con.selectMontoRetiros(cuentaInt);
						
						out.println("<!DOCTYPE html>\r\n" + 
								"<html style=\"width: 706px; height: 1064px\">\r\n" + 
								"<head>\r\n" + 
								"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
								"<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\"\r\n" + 
								"	media=\"all\">\r\n" + 
								"<link rel=\"stylesheet\" href=\"format.css\">\r\n" + 
								"\r\n" + 
								"<title>Bank-iTo</title>\r\n" +
								"<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\r\n" + 
								"    <script type=\"text/javascript\">\r\n" + 
								"      google.charts.load(\"current\", {packages:[\"corechart\"]});\r\n" + 
								"      google.charts.setOnLoadCallback(drawChart);\r\n" + 
								"      function drawChart() {\r\n" + 
								"        var data = google.visualization.arrayToDataTable([\r\n" + 
								"          ['Movimiento', 'Cantidad'],\r\n" + 
								"          ['Retiros',  "+retiros+"],\r\n" + 
								"          ['Depósitos', "+debitos+"],\r\n" + 
								"          ['Transferencias', "+transferencias+"],\r\n" + 
								"        ]);\r\n" +
								"        var options = {\r\n" + 
								"          title: 'Movimientos de la cuenta "+cuenta+"',\r\n" + 
								"          is3D: true,\r\n" + 
								"		   slices: {0: {color: '"+retirosColor+"'}, 1:{color: '"+debitosColor+"'}, 2:{color: 'red'}}}\r\n" +  
								"        var chart = new google.visualization.PieChart(document.getElementById('movimientos'));\r\n" + 
								"        chart.draw(data, options);\r\n" + 
								"      }\r\n" + 
								"    </script>\r\n" + 
								"  </head>\r\n" + 
								"	<body>  \r\n" + 
								"	<fieldset style=\" text-align: left; width: 621px; height: 328px\">  \r\n" + 
								"		<legend style=\"width: 287px; \">Gráfico:</legend>  \r\n" + 
								"		<a href=\"Bank-iTo.jsp\"> <input type=\"button\" class=\"btn btn-info\" value=\"Volver\" style=\"width: 132px; height: 53px;\"></a>"+
								"		<div id=\"movimientos\" style=\"width: 466px; height: 257px;\"></div>  \r\n" + 
								"  	</fieldset>		  \r\n" + 
								"</body>  \r\n" + 
								"</html>");
						
						out.println("<!DOCTYPE html>\r\n" + 
								"<html style=\"width: 706px; height: 1064px\">\r\n" + 
								"<head>\r\n" + 
								"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
								"<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\"\r\n" + 
								"	media=\"all\">\r\n" + 
								"<link rel=\"stylesheet\" href=\"format.css\">\r\n" + 
								"\r\n" + 
								"<title>Bank-iTo</title>\r\n" +
								"  <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\r\n" + 
								"    <script type=\"text/javascript\">\r\n" + 
								"      google.charts.load('current', {'packages':['bar']});\r\n" + 
								"      google.charts.setOnLoadCallback(drawStuff);\r\n" + 
								"\r\n" + 
								"      function drawStuff() {\r\n" +  
								"        var data1 = google.visualization.arrayToDataTable([\r\n" + 
								"          ['Movimiento', 'Cantidad',{ role: 'style' }],\r\n" + 
								"          ['Retiros',  "+montoCre+",'"+retirosColor+"'],\r\n" + 
								"          ['Depósitos', "+montoDeb+",'"+debitosColor+"'],\r\n" + 
								"        ]);\r\n" +
								"        var options1 = {\r\n" + 
								"          title: 'Montos por movimientos',\r\n" + 
								"          width: 900,\r\n" + 
								"          legend: { position: 'none' },\r\n" + 
								"          chart: { title: 'Movimientos',\r\n" + 
								"                   subtitle: 'Montos por movimientos' },\r\n" + 
								"          bars: 'horizontal', // Required for Material Bar Charts.\r\n" + 
								"          axes: {\r\n" + 
								"            x: {\r\n" + 
								"              0: { side: 'top', label: 'Montos'} // Top x-axis.\r\n" + 
								"            }\r\n" + 
								"          },\r\n" + 
								"          bar: { groupWidth: \"90%\" }\r\n" + 
								"        };\r\n" + 
								"\r\n" + 
								"        var chart = new google.charts.Bar(document.getElementById('DATOS'));\r\n" + 
								"        chart.draw(data1, options1);\r\n" + 
								"      };\r\n" + 
								"    </script>\r\n" + 
								"  \r\n" + 
								"</head>\r\n" + 
								"<body style=\"width: 424px; height: 256px;\">\r\n" + 
								"<fieldset style=\" text-align: left; width: 381px; height: 250px\">\r\n" + 
								"	<legend style=\"width: 287px; \">Gráfico:</legend>\r\n" + 
								"	<div id=\"DATOS\" style=\"background-color: #f1f1f1;width: 405px; height: 186px;\"></div>\r\n" + 
								"</fieldset>\r\n" + 
								"</body>" + 
								"</html>");
					}
					else
					{
						System.out.println("Mantenimiento");
						int intentos = con.selectIntentosPin();
						if(intentos<3)
						{
							con.actualizarIntentoPin(intentos+1);
							response.sendRedirect("Bank-iTo.jsp");
						}
						else if (intentos==3)
						{
							con.actualizarIntentoPin(0);
							con.actualizarEstatusCuenta(Integer.parseInt(cuenta));
							
							String correo = con.selectLogin();
							String mensaje = "La cuenta "+cuenta+" se inactivó por equivocarse más de tres veces en el pin.";
							
							EnviarMail mail = EnviarMail.getMail();
							mail.EnviarCorreo(correo, mensaje,"Inactivación",cuenta);
							out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('"+mensaje+"'); window.location='Bank-iTo.jsp'\"></body></html>");
						}
						else
						{
							out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Raios .__.'); window.location='Bank-iTo.jsp'\"></body></html>");
						}
					}
				}
				catch (Exception e) 
				{
					out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Verifique que los datos ingresados sean correctos.'); window.location='Bank-iTo.jsp'\"></body></html>");
				}
			}
			else
			{
				out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('La cuenta "+cuenta+" está inactiva.'); window.location='Bank-iTo.jsp'\"></body></html>");
			}
		} 
		catch (Exception e) 
		{
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('La cuenta "+cuenta+" no existe.'); window.location='Bank-iTo.jsp'\"></body></html>");
		} 
	}

}

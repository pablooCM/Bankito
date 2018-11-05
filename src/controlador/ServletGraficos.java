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
								"          google.charts.load('current', {'packages':['corechart']});\r\n" + 
								"    google.charts.setOnLoadCallback(drawChart);\r\n" + 
								"\r\n" + 
								"    function drawChart() {\r\n" + 
								"\r\n" + 
								"      var data = new google.visualization.DataTable();\r\n" + 
								"      data.addColumn('string', 'Pizza');\r\n" + 
								"      data.addColumn('number', 'Populartiy');\r\n" + 
								"      data.addRows([\r\n" + 
								"        ['Pepperoni', 33],\r\n" + 
								"        ['Hawaiian', 26],\r\n" + 
								"        ['Mushroom', 22],\r\n" + 
								"        ['Sausage', 10], // Below limit.\r\n" + 
								"        ['Anchovies', 9] // Below limit.\r\n" + 
								"      ]);\r\n" + 
								"\r\n" + 
								"      var options = {\r\n" + 
								"        title: 'Popularity of Types of Pizza',\r\n" + 
								"        sliceVisibilityThreshold: .2\r\n" + 
								"      };\r\n" + 
								"\r\n" + 
								"      var chart = new google.visualization.PieChart(document.getElementById('MOVIMIENTOS'));\r\n" + 
								"      chart.draw(data, options);\r\n" + 
								"    }"+
								"    </script>\r\n" + 
								"  \r\n" + 
								"</head>\r\n" + 
								"<body style=\"width: 485px; height: 555px; \">\r\n" + 
								"	<fieldset style=\" text-align: left; width: 381px; height: 394px\">\r\n" + 
								"		<legend style=\"width: 287px; \">Reportes cuenta: "+cuenta+":</legend>\r\n" + 
								"		<p style=\"text-align: center; width: 358px\" >\r\n" + 
								"			<a href=\"Consultas.jsp\"> <input type=\"button\" class=\"btn btn-info\" value=\"Volver\" style=\"width: 132px; height: 53px;\"></a>\r\n" + 								 
								"		</p>" + 
								"		<div id=\"MOVIMIENTOS\" style=\"background-color: #f1f1f1;width: 360px; height: 270px;\"></div>\r\n" + 
								"  	</fieldset>		\r\n" + 
								"</body>\r\n" + 
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
								"        var data = new google.visualization.arrayToDataTable([\r\n" + 
								"          ['Opening Move', 'Percentage'],\r\n" + 
								"          [\"King's pawn (e4)\", 44],\r\n" + 
								"          [\"Queen's pawn (d4)\", 31],\r\n" + 
								"          [\"Knight to King 3 (Nf3)\", 12],\r\n" + 
								"          [\"Queen's bishop pawn (c4)\", 10],\r\n" + 
								"          ['Other', 3]\r\n" + 
								"        ]);\r\n" + 
								"\r\n" + 
								"        var options = {\r\n" + 
								"          title: 'Chess opening moves',\r\n" + 
								"          width: 900,\r\n" + 
								"          legend: { position: 'none' },\r\n" + 
								"          chart: { title: 'Chess opening moves',\r\n" + 
								"                   subtitle: 'popularity by percentage' },\r\n" + 
								"          bars: 'horizontal', // Required for Material Bar Charts.\r\n" + 
								"          axes: {\r\n" + 
								"            x: {\r\n" + 
								"              0: { side: 'top', label: 'Percentage'} // Top x-axis.\r\n" + 
								"            }\r\n" + 
								"          },\r\n" + 
								"          bar: { groupWidth: \"90%\" }\r\n" + 
								"        };\r\n" + 
								"\r\n" + 
								"        var chart = new google.charts.Bar(document.getElementById('DATOS'));\r\n" + 
								"        chart.draw(data, options);\r\n" + 
								"      };\r\n" + 
								"    </script>\r\n" + 
								"  \r\n" + 
								"</head>\r\n" + 
								"<body style=\"width: 485px; height: 555px; \">\r\n" + 
								"	<fieldset style=\" text-align: left; width: 381px; height: 394px\">\r\n" + 
								"		<div id=\"DATOS\" style=\"background-color: #f1f1f1;width: 360px; height: 270px;\"></div>\r\n" + 
								"  	</fieldset>		\r\n" + 
								"</body>\r\n" + 
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
							out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('La cuenta "+cuenta+" se inactivó por equivocarse más de tres veces en el pin.'); window.location='Bank-iTo.jsp'\"></body></html>");
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

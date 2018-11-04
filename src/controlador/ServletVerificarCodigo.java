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
 * Servlet implementation class ServletVerificarCodigo
 */
@WebServlet("/ServletVerificarCodigo")
public class ServletVerificarCodigo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVerificarCodigo() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String cuenta = request.getParameter("cuenta").toString();
		String codigo= request.getParameter("codigo").toString();
		String tipo= request.getParameter("tipo").toString().toLowerCase();
		String pin= request.getParameter("pin").toString();
		
		BaseDatos con = new BaseDatos();
		String codigo_v = null;
		
		PrintWriter out = response.getWriter();	

		try 
		{
			if(con.selectEstatus(Integer.parseInt(cuenta)).equals("activa"))
			{
				try 
				{
			        String pinEncriptado = MD5.Encriptar(pin);
			         
			        System.out.println("Verifica:"+pinEncriptado);
					
					int cuenta_consult = con.selectCuenta(cuenta, pinEncriptado);
			        
					if(cuenta_consult != 0)
					{
						codigo_v = con.selectCodigo();
						if(codigo_v.equals(codigo))
						{
							if (tipo.equals("colones"))
							{
								out.println("<!DOCTYPE html>\r\n" + 
										"<html style=\"width: 644px; height: 993px; \">\r\n" + 
										"<head>\r\n" + 
										"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
										"<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\"\r\n" + 
										"	media=\"all\">\r\n" + 
										"\r\n" + 
										"<title>Bank-iTo</title>\r\n" + 
										"\r\n" + 
										"<style>\r\n" + 
										"html\r\n" + 
										"{\r\n" + 
										"	text-align: center;\r\n" + 
										"}\r\n" + 
										"body {\r\n" + 
										"	margin: 20px;\r\n" + 
										"	max-width: 800px;\r\n" + 
										"	padding: 20px;\r\n" + 
										"	background: url('img/bankito.png');	\r\n" + 
										"    background-repeat: no-repeat;\r\n" + 
										"    background-size: 430px 550px;	\r\n" + 
										"	\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".container {\r\n" + 
										"	border: 2px solid #dedede;\r\n" + 
										"	background-color: #f1f1f1;\r\n" + 
										"	border-radius: 5px;\r\n" + 
										"	padding: 10px;\r\n" + 
										"	margin: 10px 0;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".darker {\r\n" + 
										"	border-color: #ccc;\r\n" + 
										"	background-color: #ddd;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".container::after {\r\n" + 
										"	content: \"\";\r\n" + 
										"	clear: both;\r\n" + 
										"	display: table;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".container img {\r\n" + 
										"	float: left;\r\n" + 
										"	max-width: 60px;\r\n" + 
										"	width: 100%;\r\n" + 
										"	margin-right: 20px;\r\n" + 
										"	border-radius: 50%;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".container img.right {\r\n" + 
										"	float: right;\r\n" + 
										"	margin-left: 20px;\r\n" + 
										"	margin-right: 0;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".time-right {\r\n" + 
										"	float: right;\r\n" + 
										"	color: #aaa;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".time-left {\r\n" + 
										"	float: left;\r\n" + 
										"	color: #999;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										"</style>\r\n" + 
										"\r\n" + 
										"</head>\r\n" + 
										"<body style=\"width: 472px; height: 520px; \">\r\n" + 
										"	<fieldset style=\"text-align: left; width: 381px; height: 541px\">\r\n" + 
										"		<legend style=\"width: 296px; \">Realizar retiro:</legend>\r\n" + 
										"		<form action=\"ServletRetiro\" method=\"post\" style=\"width: 375px; height: 339px\">			\r\n" + 
										"			<p style=\"width: 369px; height: 37px\">\r\n" + 
										"				<label for=\"cuenta\" style=\"width: 143px;\">Número de cuenta:</label>\r\n" + 
										"				<input value=\""+cuenta+"\" name=\"cuenta\" type=\"text\" id=\"cuenta\" class=\"cuenta\" style=\"width: 202px;\">"+ 
										"	        </p> 	\r\n" + 
										"			<p>\r\n" + 
										"				<label for=\"monto\" style=\"width: 143px;\">Monto a retirar:</label> \r\n" + 
										"				<input name=\"monto\" type=\"number\" id=\"monto\" class=\"monto\" style=\"width: 110px;\">		\r\n" + 
										"				<input name=\"tipo\" type=\"text\" id=\"tipo\" class=\"tipo\" value=\"colones\" style=\"text-align:center; width: 353px;\"> \r\n" + 
										"			</p>\r\n" + 
										"			<p style=\"text-align: center; width: 358px\" >\r\n" + 
										"				<a href=\"codigoVerificacion.jsp\"> <input type=\"button\" class=\"btn btn-info\" value=\"Volver\" style=\"width: 132px; height: 53px;\"></a>\r\n" + 
										"				<input type=\"submit\" class=\"btn btn-warning\" value=\"Validar retiro\" style=\"width: 169px; height: 53px;\">				\r\n" + 
										"			</p>\r\n" + 
										"		</form>\r\n" + 
										"	</fieldset>\r\n" + 
										"</body>\r\n" + 
										"</html>");				
							}
							else if (tipo.equals("dólares"))
							{
								out.println("<!DOCTYPE html>\r\n" + 
										"<html style=\"width: 644px; height: 993px; \">\r\n" + 
										"<head>\r\n" + 
										"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
										"<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\"\r\n" + 
										"	media=\"all\">\r\n" + 
										"\r\n" + 
										"<title>Bank-iTo</title>\r\n" + 
										"\r\n" + 
										"<style>\r\n" + 
										"html\r\n" + 
										"{\r\n" + 
										"	text-align: center;\r\n" + 
										"}\r\n" + 
										"body {\r\n" + 
										"	margin: 20px;\r\n" + 
										"	max-width: 800px;\r\n" + 
										"	padding: 20px;\r\n" + 
										"	background: url('img/bankito.png');	\r\n" + 
										"    background-repeat: no-repeat;\r\n" + 
										"    background-size: 430px 550px;	\r\n" + 
										"	\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".container {\r\n" + 
										"	border: 2px solid #dedede;\r\n" + 
										"	background-color: #f1f1f1;\r\n" + 
										"	border-radius: 5px;\r\n" + 
										"	padding: 10px;\r\n" + 
										"	margin: 10px 0;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".darker {\r\n" + 
										"	border-color: #ccc;\r\n" + 
										"	background-color: #ddd;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".container::after {\r\n" + 
										"	content: \"\";\r\n" + 
										"	clear: both;\r\n" + 
										"	display: table;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".container img {\r\n" + 
										"	float: left;\r\n" + 
										"	max-width: 60px;\r\n" + 
										"	width: 100%;\r\n" + 
										"	margin-right: 20px;\r\n" + 
										"	border-radius: 50%;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".container img.right {\r\n" + 
										"	float: right;\r\n" + 
										"	margin-left: 20px;\r\n" + 
										"	margin-right: 0;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".time-right {\r\n" + 
										"	float: right;\r\n" + 
										"	color: #aaa;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".time-left {\r\n" + 
										"	float: left;\r\n" + 
										"	color: #999;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										"</style>\r\n" + 
										"\r\n" + 
										"</head>\r\n" + 
										"<body style=\"width: 472px; height: 520px; \">\r\n" + 
										"	<fieldset style=\"text-align: left; width: 381px; height: 541px\">\r\n" + 
										"		<legend style=\"width: 296px; \">Realizar retiro:</legend>\r\n" + 
										"		<form action=\"ServletRetiroDolares\" method=\"post\" style=\"width: 375px; height: 339px\">			\r\n" + 
										"			<p style=\"width: 369px; height: 37px\">\r\n" + 
										"				<label for=\"cuenta\" style=\"width: 143px;\">Número de cuenta:</label>\r\n" + 
										"				<input value=\""+cuenta+"\" name=\"cuenta\" type=\"text\" id=\"cuenta\" class=\"cuenta\" style=\"width: 202px;\">" + 
										"	        </p> 	\r\n" + 
										"			<p>\r\n" + 
										"				<label for=\"monto\" style=\"width: 143px;\">Monto a retirar:</label> \r\n" + 
										"				<input name=\"monto\" type=\"number\" id=\"monto\" class=\"monto\" style=\"width: 110px;\">		\r\n" + 
										"				<input name=\"tipo\" type=\"text\" id=\"tipo\" class=\"tipo\" value=\"dólares\" style=\"text-align:center; width: 353px;\"> \r\n" + 
										"			</p>\r\n" + 
										"			<p style=\"text-align: center; width: 358px\" >\r\n" + 
										"				<a href=\"codigoVerificacion.jsp\"> <input type=\"button\" class=\"btn btn-info\" value=\"Volver\" style=\"width: 132px; height: 53px;\"></a>\r\n" + 
										"				<input type=\"submit\" class=\"btn btn-warning\" value=\"Validar retiro\" style=\"width: 169px; height: 53px;\">				\r\n" + 
										"			</p>\r\n" + 
										"		</form>\r\n" + 
										"	</fieldset>\r\n" + 
										"</body>\r\n" + 
										"</html>");	
							}
							else
							{
								out.println("<!DOCTYPE html>\r\n" + 
										"<html style=\"width: 706px; height: 1064px\">\r\n" + 
										"<head>\r\n" + 
										"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
										"<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\"\r\n" + 
										"	media=\"all\">\r\n" + 
										"<link rel=\"stylesheet\" href=\"format.css\">\r\n" + 
										"\r\n" + 
										"<title>Bank-iTo</title>\r\n" + 
										"\r\n" + 
										"<style>\r\n" + 
										"html\r\n" + 
										"{\r\n" + 
										"	text-align: center;\r\n" + 
										"}\r\n" + 
										"body {\r\n" + 
										"	margin: 20px;\r\n" + 
										"	max-width: 800px;\r\n" + 
										"	padding: 20px;\r\n" + 
										"	background: url('img/bankito.png');	\r\n" + 
										"    background-repeat: no-repeat;\r\n" + 
										"    background-size: 430px 550px;	\r\n" + 
										"	\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".container {\r\n" + 
										"	border: 2px solid #dedede;\r\n" + 
										"	background-color: #f1f1f;\r\n" + 
										"	border-radius: 5px;\r\n" + 
										"	padding: 10px;\r\n" + 
										"	margin: 10px 0;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".darker {\r\n" + 
										"	border-color: #ccc;\r\n" + 
										"	background-color: #ddd;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".container::after {\r\n" + 
										"	content: \"\";\r\n" + 
										"	clear: both;\r\n" + 
										"	display: table;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".container img {\r\n" + 
										"	float: left;\r\n" + 
										"	max-width: 60px;\r\n" + 
										"	width: 100%;\r\n" + 
										"	margin-right: 20px;\r\n" + 
										"	border-radius: 50%;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".container img.right {\r\n" + 
										"	float: right;\r\n" + 
										"	margin-left: 20px;\r\n" + 
										"	margin-right: 0;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".time-right {\r\n" + 
										"	float: right;\r\n" + 
										"	color: #aaa;\r\n" + 
										"}\r\n" + 
										"\r\n" + 
										".time-left {\r\n" + 
										"	float: left;\r\n" + 
										"	color: #999;\r\n" + 
										"}\r\n" + 
										"</style>\r\n" + 
										"</head>\r\n" + 
										"<body style=\"width: 485px; height: 555px; \">\r\n" + 
										"	<fieldset style=\" text-align: left; width: 381px; height: 394px\">\r\n" + 
										"		<legend style=\"width: 287px; \">Transferencia:</legend>\r\n" + 
										"		<form action=\"ServletTransferencia\" method=\"post\" style=\"width: 375px; height: 339px\">\r\n" + 
										"			<p style=\"width: 369px; height: 37px\">\r\n" + 
										"				<label for=\"cuenta\" style=\"width: 143px;\">Número de cuenta:</label>\r\n" + 
										"				<input value=\""+cuenta+"\" name=\"cuenta\" type=\"text\" id=\"cuenta\" class=\"cuenta\" style=\"width: 202px;\">"+ 
										"	        </p> 	\r\n" + 
										"			<p>\r\n" + 
										"				<label for=\"montoTransferir\" style=\"width: 143px;\">Monto a transferir:</label>  \r\n" + 
										"				<input name=\"montoTransferir\" type=\"number\" id=\"montoTransferir\" class=\"montoTransferir\" style=\"width: 136px;\">\r\n" + 
										"				colones.		\r\n" + 
										"			</p>	\r\n" + 
										"					<p style=\"width: 369px; height: 37px\">\r\n" + 
										"					<label for=\"cuentaA\" style=\"width: 143px;\">Cuenta a acreditar:</label>\r\n" + 
										"					<input name=\"cuentaA\" type=\"text\" id=\"cuentaA\" class=\"cuentaA\" style=\"width: 202px;\">\r\n" + 
										"			</p> 		\r\n" + 
										"			<p style=\"text-align: center; width: 358px\" >\r\n" + 
										"				<a href=\"codigoVerificacionTransferencia.jsp\"> <input type=\"button\" class=\"btn btn-info\" value=\"Volver\" style=\"width: 132px; height: 53px;\"></a>\r\n" + 
										"				<input type=\"submit\" class=\"btn btn-warning\" value=\"Transeferir\" style=\"width: 132px; height: 53px;\">\r\n" + 
										"			</p>\r\n" + 
										"		</form>\r\n" + 
										"	</fieldset>		\r\n" + 
										"</body>\r\n" + 
										"</html>");		
							}
						}
						else
						{
							System.out.println("Mantenimiento");
						}
					}
					else
					{
						
					}
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
			else
			{
				out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('La cuenta "+cuenta+" está inactiva.'); window.location='codigoVerificacionDolares.jsp'\"></body></html>");
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('La cuenta "+cuenta+" no existe.'); window.location='codigoVerificacionDolares.jsp'\"></body></html>");
		} 
	}

}

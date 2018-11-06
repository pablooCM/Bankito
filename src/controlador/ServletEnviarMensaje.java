package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaAccesoaDatos.BaseDatos;
import logicaIntegracion.CodigoVerificacion;
import logicaIntegracion.EnviarMensaje;
/**
 * Servlet implementation class ServletEnviarMensaje
 */
@WebServlet("/ServletEnviarMensaje")
public class ServletEnviarMensaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEnviarMensaje() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cuenta = request.getParameter("cuenta").toString();
		String pin= request.getParameter("pin").toString();

		PrintWriter out = response.getWriter();
		try 
		{
			CodigoVerificacion random = new CodigoVerificacion();
			String codigo = random.crearCodigoRandom();
			System.out.println(codigo);
			BaseDatos con = new BaseDatos();
			

			String correo = con.selectLogin();
			String telefono = con.selectTelefono(correo);
			
			if(telefono != null) 
			{
				System.out.println(telefono);
				con.insertarCodigoVerificacion(codigo);
				
				EnviarMensaje enviar = new EnviarMensaje();
				enviar.enviarCodigo(codigo, telefono);
				
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
						"		<form action=\"ServletVerificarCodigo\" method=\"post\" style=\"width: 375px; height: 305px\">\r\n" + 
						"			<p style=\"width: 369px; height: 37px\">\r\n" + 
						"				<label for=\"cuenta\" style=\"width: 143px;\">Número de cuenta:</label>\r\n" + 
						"				<input value=\""+cuenta+"\" name=\"cuenta\" type=\"text\" id=\"cuenta\" class=\"cuenta\" style=\"width: 202px;\">\r\n" + 
						"			</p> 	\r\n" + 
						"			<p style=\"width: 369px; height: 37px\">\r\n" + 
						"				<label for=\"pin\" style=\"width: 143px;\">Pin:</label>\r\n" + 
						"				<input value=\""+pin+"\" name=\"pin\" type=\"text\" id=\"pin\" class=\"pin\" style=\"width: 202px;\">\r\n" + 
						"			</p>	\r\n" + 
						"			<input name=\"tipo\" type=\"text\" id=\"tipo\" class=\"tipo\" value=\"colones\" style=\"text-align:center; width: 353px;\">\r\n" + 
						"			<div id=\"campo\" style=\"text-align: center; width: 351px\" >\r\n" + 
						"			<input name = \"codigo\" type=\"text\" id =\"codigo\" class = \"codigo\" style = \"width: 202px;\">" + 						
						"			</div>			\r\n" + 
						"			<br>\r\n" + 
						"			<br>\r\n" + 
						"			<div style=\"text-align: center; width: 358px\" >\r\n" + 
						"				<a href=\"Bank-iTo.jsp\"> <input type=\"button\" class=\"btn btn-info\" value=\"Volver\" style=\"width: 132px; height: 53px;\"></a>\r\n" + 
						"				<input type=\"submit\" class=\"btn btn-warning\" value=\"Validar código.\" style=\"width: 169px; height: 53px;\">				\r\n" + 
						"			</div>\r\n" + 
						"		</form>\r\n" + 						 
						"	</fieldset>\r\n" + 
						"</body>\r\n" + 
						"</html>");
			}
			else
			{
				out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Verifique que los datos ingresados sean correctos.'); window.location='Bank-iTo.jsp'\"></body></html>");
			}
		}		
        
		catch (Exception e)
		{
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Verifique que los datos ingresados sean correctos.'); window.location='Bank-iTo.jsp'\"></body></html>");
		}
	}

}

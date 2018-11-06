package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaAccesoaDatos.BaseDatos;

/**
 * Servlet implementation class ServletVerHistorial
 */
@WebServlet("/ServletVerHistorial")
public class ServletVerHistorial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVerHistorial() {
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
		
		PrintWriter out = response.getWriter();	
		BaseDatos con = new BaseDatos();
		try 
		{

			String correo = con.selectLogin();
			String nombre = con.selectNombreDuenno(correo);
			int idDuenno = con.selectIdDueno(nombre);
			
			String mensaje = write(con.selectHistorial(idDuenno));
			out.println("<!DOCTYPE html>\r\n" + 
					"<html style=\"width: 577px; height: 855px; \">\r\n" + 
					"<head>\r\n" + 
					"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\"\r\n" + 
					"	media=\"all\">\r\n" + 
					"\r\n" + 
					"<title>Bank-iTo</title>\r\n" + 
					"\r\n" + 
					"<style>\r\n" +
					" table.example-table, .example-table td {\r\n" + 
					"  margin: 15px;\r\n" + 
					"  padding: 15px;\r\n" + 
					"}\r\n" +
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
					"<body style=\"width: 472px; height: 780px; \">\r\n" + 
					"	<fieldset style=\"text-align: left; width: 381px; height: 394px\">\r\n" + 
					"		<legend style=\"width: 340px; \">Módulo Bitácora:</legend>\r\n" + 
					"		<form action=\"ServletAlmacenarHistorial\" method=\"post\" style=\"width: 375px; height: 231px\">\r\n" + 
					"			<p style=\"width: 481px;\">\r\n" + 
					"				<label for=\"fecha\" style=\"width: 147px;\">Fecha:</label> \r\n" + 
					"					<input size=\"9\" type=\"date\" id=\"fecha\" name=\"fecha\" style=\"width: 197px;\">\r\n" + 
					"			</p>\r\n" + 
					"			<p style=\"width: 477px;\">\r\n" + 
					"				<label for=\"horaInicio\" style=\"width: 144px;\">Hora Inicio:</label>\r\n" + 
					"					<input name=\"horaInicio\" type=\"text\" id=\"horaInicio\" class=\"horaInicio\" style=\"width: 200px;\"> \r\n" + 
					"			</p>				\r\n" + 
					"			<p style=\"width: 369px; height: 37px\">\r\n" + 
					"				<label for=\"accion\" style=\"width: 143px;\">Acción realizada:</label>\r\n" + 
					"				<input name=\"accion\" type=\"text\" id=\"accion\" class=\"accion\" style=\"width: 202px;\"> 				\r\n" + 
					"			</p>\r\n" + 
					"			<p style=\"text-align: center; width: 361px\" >\r\n" + 
					"				<a href=\"Bank-iTo.jsp\"> <input type=\"button\" class=\"btn btn-info\" value=\"Volver\" style=\"width: 132px; height: 53px;\"></a>\r\n" + 
					"				<input type=\"submit\" class=\"btn btn-warning\" value=\"Registrar\" style=\"width: 132px; height: 53px;\">\r\n" + 
					"			</p>\r\n" + 
					"		</form>\r\n"+
					"		<div>"+ mensaje +"</div>" +
					"	</fieldset>	\r\n" + 
					"</body>\r\n" + 
					"</html>");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String write(ResultSet rs) throws IOException, SQLException{

	    ResultSetMetaData md = rs.getMetaData();
	    int count = md.getColumnCount();
	    String mensaje = "<table class=\"example-table\"><tr>";
	    
	    for (int i=1; i<=count; i++) {
	    	mensaje += "<th>";
	    	mensaje += md.getColumnLabel(i);
	    }
	    mensaje += "</tr>";
	    while (rs.next()) 
	    {
	    	mensaje +="<tr>";
	    	for (int i=1; i<=count; i++) 
	    	{
	    		mensaje += "<td>";
	    		mensaje += rs.getString(i);
	    	}
	    	mensaje += "</tr>";
	    }
	    mensaje += "</table>";
	    return mensaje;
	  }


}

package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaAccesoaDatos.BaseDatos;
import logicaIntegracion.EnviarMail;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	doPost(request, response);
	}
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String correo = request.getParameter("correo").toString();
		String contrasenna= request.getParameter("contrasenna").toString();
		
		BaseDatos con = new BaseDatos();
		String user = null;
		String nombreDuenno = null;
		
		PrintWriter out = response.getWriter();
		
		try 
		{
			user = con.selectLogin(correo, contrasenna);
			nombreDuenno = con.selectNombreDuenno(correo);
			con.insertarLogin(correo);
			EnviarMail.getMail();
			
		} 
		catch (SQLException e) 
		{
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Verifique que los datos ingresados sean correctos.'); window.location='Bank-iTo.jsp'\"></body></html>");
		}
		
		if (user != null )
		{
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('¡Bienvenido "+nombreDuenno+"!'); window.location='Bank-iTo.jsp' \"></body></html>");
		} 
		else
		{
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Verifique que los datos ingresados correspondan con algún usuario asociado con alguna cuenta previamente registrada.'); window.location='login.jsp' \"></body></html>");
		}
	}

}

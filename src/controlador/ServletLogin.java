package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import logicaAccesoaDatos.BaseDatos;
import logicaIntegracion.EnviarMail;
=======
import logicaAccesoaDatos.BaseDatosN;
>>>>>>> 98eb02b7e420d8b3972fbe0b5223f32e65001354

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
		
		BaseDatosN con = new BaseDatosN();
		String user = null;
		String nombreDuenno = null;
		
		PrintWriter out = response.getWriter();
		
		try 
		{
			user = con.selectLogin(correo, contrasenna);
			nombreDuenno = con.selectNombreDuenno(correo);
			request.getSession().setAttribute("user", user);   
			EnviarMail.getMail();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		if (user != null )
		{
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('�Bienvenido "+nombreDuenno+"!'); window.location='Bank-iTo.jsp' \"></body></html>");
		} 
		else
		{
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Verifique que los datos ingresados correspondan con alg�n usuario asociado con alguna cuenta previamente registrada.'); window.location='login.jsp' \"></body></html>");
		}
	}

}

package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaAccesoaDatos.BaseDatos;
import logicaDeNegocios.ValidarDatos;
import logicaIntegracion.CodigoVerificacion;
import logicaIntegracion.EnviarMail;

/**
 * Servlet implementation class ServletCambiarCorreo
 */
@WebServlet("/ServletCambiarCorreo")
public class ServletCambiarCorreo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCambiarCorreo() {
        super();
        // TODO Auto-generated constructor stub
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
		String contrasenna = request.getParameter("password").toString();
		
		ValidarDatos validar = new ValidarDatos();
		
		if (validar.validarCorreoElectronico(correo))
		{
			try 
			{
				EnviarMail.setDatos(correo, contrasenna);
				PrintWriter out = response.getWriter();
				out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('La cuenta para enviar notificaciones será "+correo+".'); window.location='Bank-iTo.jsp' \"></body></html>");
			} 
			catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		else
		{
			PrintWriter out = response.getWriter();
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('El email no es correcto.\nError a la hora de actualizar la cuenta par enviar notificaciones.'); window.location='Bank-iTo.jsp' \"></body></html>");
		}
		
		
	}

}

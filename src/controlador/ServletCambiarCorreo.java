package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import logicaAccesoaDatos.BaseDatos;
import logicaDeNegocios.MD5;
=======
import logicaAccesoaDatos.BaseDatosN;
import logicaDeNegocios.ValidarDatos;
import logicaIntegracion.CodigoVerificacion;
import logicaIntegracion.EnviarMail;
>>>>>>> 98eb02b7e420d8b3972fbe0b5223f32e65001354

/**
 * Servlet implementation class ServletCambiarCorreo
 */
@WebServlet("/ServletCambiarCorreo")
public class ServletCambiarCorreo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		String correoNuevo = request.getParameter("correo").toString();
		
		BaseDatos con = new BaseDatos();

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
						String correoAnterior = con.selectCorreo(Integer.parseInt(cuenta)); 
						con.actualizarCorreo(correoNuevo, correoAnterior);
						request.getSession().setAttribute("user", correoNuevo);
						out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('El correo: "+correoAnterior+" ahora es: "+correoNuevo+"'); window.location='codigoVerificacionDolares.jsp'\"></body></html>");
					}
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		} 
		catch (Exception e) 
		{
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('La cuenta "+cuenta+" no existe.'); window.location='codigoVerificacionDolares.jsp'\"></body></html>");
		} 
	}

}

package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaAccesoaDatos.BaseDatos;
import logicaDeNegocios.CambioCorreo;
import logicaDeNegocios.MD5;
import logicaDeNegocios.ValidarDatos;

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
			        
					ValidarDatos validar = new ValidarDatos();
					if(cuenta_consult != 0 && validar.validarCorreoElectronico(correoNuevo)==true)
					{			
						con.actualizarIntentoPin(0);
						String correoAnterior = con.selectCorreo(Integer.parseInt(cuenta)); 
						String nombreDuenno = con.selectNombreDuenno(correoAnterior);
						CambioCorreo cambiar = new CambioCorreo(nombreDuenno, correoNuevo);
						cambiar.actualizarBaseDatos();
						con.insertarLogin(correoNuevo);
						out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Estimado usuario, usted ha cambiado la dirección de correo "+correoAnterior+" por "+correoNuevo+"'); window.location='Bank-iTo.jsp'\"></body></html>");
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
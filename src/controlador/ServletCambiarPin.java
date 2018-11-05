package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaAccesoaDatos.BaseDatos;
import logicaDeNegocios.CambioPin;
import logicaDeNegocios.MD5;
import logicaDeNegocios.ValidarDatos;

/**
 * Servlet implementation class ServletCambiarPin
 */
@WebServlet("/ServletCambiarPin")
public class ServletCambiarPin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCambiarPin() {
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
		String pin= request.getParameter("pinA").toString();
		String pinNuevo= request.getParameter("pin").toString();
		
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
					
					
					if(cuenta_consult != 0 && validar.validarPin(pinNuevo))
					{			 
						String pinEncriptadoNuevo = MD5.Encriptar(pinNuevo);
				         
				        System.out.println("Verifica:"+pinEncriptado);
						CambioPin cambiar = new CambioPin(Integer.parseInt(cuenta), pinEncriptadoNuevo);
						cambiar.actualizarBaseDatos();
						out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Estimado usuario, se ha cambiado satisfactoriamente el PIN de su cuenta "+cuenta+"'); window.location='Bank-iTo.jsp'\"></body></html>");
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

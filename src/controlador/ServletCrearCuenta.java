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

/**
 * Servlet implementation class CreateCuenta
 */
@WebServlet("/ServletCrearCuenta")
public class ServletCrearCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCrearCuenta() {
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
		String pin = request.getParameter("pin").toString();
		String nombre = request.getParameter("nombre").toString();
		String telefono = request.getParameter("telefono").toString();
		String correo = request.getParameter("correo").toString();
		String montoInicial = request.getParameter("montoInicial").toString();
		
		CodigoVerificacion random = new CodigoVerificacion();
		String contrasenna = random.crearCodigoRandom();
		
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		BaseDatos con = new BaseDatos();
		
		ValidarDatos validar = new ValidarDatos();
		
		if (validar.validarCorreoElectronico(correo)==true && validar.validarTelefono(telefono)==true)
		{
			try 
			{
				con.insertarCuenta(nombre, correo, telefono, contrasenna, pin, "activa", sqlDate, Double.parseDouble(montoInicial));
				
				String pass = con.selectContrasennaDueno(nombre);
				
				PrintWriter out = response.getWriter();
				out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Su contraseña para iniciar sesión con el correo "+correo+", es "+pass+".'); window.location='login.jsp' \"></body></html>");
			} 
			catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			PrintWriter out = response.getWriter();
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('El email y/o el número de teléfono no es correcto.\nIntente registrar la cuenta de nuevo.'); window.location='login.jsp' \"></body></html>");
		}
		
		
	}

}

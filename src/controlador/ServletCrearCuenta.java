package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.DTOCuenta;
import logicaAccesoaDatos.BaseDatos;
import logicaDeNegocios.MD5;
import logicaDeNegocios.RegistroCuenta;
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
		

		PrintWriter out = response.getWriter();
		
		if (validar.validarCorreoElectronico(correo)==true && validar.validarTelefono(telefono)==true && validar.validarPin(pin))
		{
			try 
			{
				String pinEncriptado = MD5.Encriptar(pin);
		        
		        System.out.println("Crea:"+pinEncriptado);
		        DTOCuenta dtoCuenta = new DTOCuenta(0, nombre, correo, telefono, "activa", Double.parseDouble(montoInicial), sqlDate, pinEncriptado);
				
		        RegistroCuenta.registrarCuenta(dtoCuenta, contrasenna);
				String pass = con.selectContrasennaDueno(nombre);
				String cuenta = Integer.toString(con.selectIdCuenta(pinEncriptado, "activa", sqlDate, Double.parseDouble(montoInicial)));
				
				out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Se creo la cuenta: "+cuenta+". Su contraseña para iniciar sesión con el correo "+correo+", es "+pass+".'); window.location='login.jsp' \"></body></html>");
			} 
			catch (Exception e) 
			{
				out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Verifique que los datos ingresados sean correctos.'); window.location='Bank-iTo.jsp'\"></body></html>");
			}
		}
		else
		{
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('El email y/o el número de teléfono no es correcto.\nIntente registrar la cuenta de nuevo.'); window.location='login.jsp' \"></body></html>");
		}
		
		
	}

}

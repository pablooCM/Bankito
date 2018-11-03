package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaAccesoaDatos.BaseDatos;
import logicaDeNegocios.RSA;
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
		
		if (validar.validarCorreoElectronico(correo)==true && validar.validarTelefono(telefono)==true)
		{
			try 
			{
				//Instanciamos la clase
		        RSA rsa = new RSA();
		         
		        //Generamos un par de claves
		        //Admite claves de 512, 1024, 2048 y 4096 bits
		        rsa.genKeyPair(512);
		        
		        //Las guardamos asi podemos usarlas despues
		        //a lo largo del tiempo
		        rsa.saveToDiskPrivateKey("rsa.pri");
		        rsa.saveToDiskPublicKey("rsa.pub");
		         
		        String pinEncriptado = rsa.Encrypt(pin);
		        
		        System.out.println("Crea:"+pinEncriptado);
		       
				//con.insertarCuenta(nombre, correo, telefono, contrasenna, pinEncriptado, "activa", sqlDate, Double.parseDouble(montoInicial));
				
				String pass = con.selectContrasennaDueno(nombre);
				
				out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Su contraseña para iniciar sesión con el correo "+correo+", es "+pass+".'); window.location='login.jsp' \"></body></html>");
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('El email y/o el número de teléfono no es correcto.\nIntente registrar la cuenta de nuevo.'); window.location='login.jsp' \"></body></html>");
		}
		
		
	}

}

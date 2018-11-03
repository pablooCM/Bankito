package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaAccesoaDatos.BaseDatosN;
import logicaDeNegocios.RSA;

/**
 * Servlet implementation class ServletVerificarCodigo
 */
@WebServlet("/ServletVerificarCodigo")
public class ServletVerificarCodigo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVerificarCodigo() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String cuenta = request.getParameter("cuenta").toString();
		String pin= request.getParameter("pin").toString();
		String codigo= request.getParameter("codigo").toString();
		String tipo= request.getParameter("tipo").toString().toLowerCase();
		
		BaseDatosN con = new BaseDatosN();
		String codigo_v = null;
		
		PrintWriter out = response.getWriter();	

		try 
		{
			//Instanciamos la clase
	        RSA rsa = new RSA();
	        
	        //A diferencia de la anterior aca no creamos
	        //un nuevo par de claves, sino que cargamos
	        //el juego de claves que habiamos guadado
	        rsa.openFromDiskPrivateKey("rsa.pri");    
	        rsa.openFromDiskPublicKey("rsa.pub");	         
	        
	        String pin_Base = con.selectPin(cuenta);
	        
			int cuenta_consult = con.selectCuenta(cuenta, pin_Base);
	        
	        String pinEncriptado = rsa.Decrypt(pin_Base);
	         
	        System.out.println("Verifica:"+pinEncriptado);
			
			if(cuenta_consult != 0)
			{
				codigo_v = con.selectCodigo();
				if(codigo_v==codigo)
				{
					if (tipo.equals("colones"))
					{
						out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Código Correcto'); window.location='retiroColones.jsp?/cuenta="+cuenta+"'\"></body></html>");				
					}
					else
					{
						out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Código Correcto'); window.location='retiroDolares.jsp?/cuenta="+cuenta+"'\"></body></html>");
					}
				}
				else
				{
					System.out.println("Mantenimiento");
				}
			}
			else
			{
				if (tipo.equals("colones"))
				{
					out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('El número de cuenta o el pin están incorrectos.'); window.location='codigoVerificacionColones.jsp'\"></body></html>");
				}
				else
				{
					out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('El número de cuenta o el pin están incorrectos.'); window.location='codigoVerificacionDolares.jsp'\"></body></html>");
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}

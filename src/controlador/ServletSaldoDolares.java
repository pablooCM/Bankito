package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaAccesoaDatos.BaseDatos;
import logicaDeNegocios.ConsultaSaldoCambioMoneda;
import logicaDeNegocios.MD5;
import logicaIntegracion.EnviarMail;
import logicaIntegracion.TipoCambio;

/**
 * Servlet implementation class ServletSaldoDolares
 */
@WebServlet("/ServletSaldoDolares")
public class ServletSaldoDolares extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
    */
    public ServletSaldoDolares() {
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
		
		BaseDatos con = new BaseDatos();

		PrintWriter out = response.getWriter();	

		int cuentaInt = Integer.parseInt(cuenta);
		try 
		{
			if(con.selectEstatus(cuentaInt).equals("activa"))
			{
				try 
				{			        
					String pinEncriptado = MD5.Encriptar(pin);
			         
			        System.out.println("Verifica:"+pinEncriptado);
					
					int cuenta_consult = con.selectCuenta(cuenta, pinEncriptado);
			        
					if(cuenta_consult != 0)
					{	
						con.actualizarIntentoPin(0);
						ConsultaSaldoCambioMoneda consulta = new ConsultaSaldoCambioMoneda(cuentaInt, pinEncriptado);
						double saldo = (double) consulta.consultarBaseDatos();
						TipoCambio cambio = new TipoCambio();
						double compra = cambio.getCompra();
						out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Estimado usuario, el saldo actual de su cuenta es "+saldo+" d�lares. Para esta conversi�n se utiliz� el tipo de cambio del d�lar, precio de compra. [Seg�n el BCCR, el tipo de cambio de compra del d�lar de hoy es: "+compra+"]'); window.location='Bank-iTo.jsp'\"></body></html>");
					}
					else
					{
						System.out.println("Mantenimiento");
						int intentos = con.selectIntentosPin();
						if(intentos<3)
						{
							con.actualizarIntentoPin(intentos+1);
							response.sendRedirect("Bank-iTo.jsp");
						}
						else if (intentos==3)
						{
							con.actualizarIntentoPin(0);
							con.actualizarEstatusCuenta(Integer.parseInt(cuenta));
							
							String correo = con.selectLogin();
							String mensaje = "La cuenta "+cuenta+" se inactiv� por equivocarse m�s de tres veces en el pin.";
							
							EnviarMail mail = EnviarMail.getMail();
							mail.EnviarCorreo(correo, mensaje,"Inactivaci�n",cuenta);
							out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('"+mensaje+"'); window.location='Bank-iTo.jsp'\"></body></html>");
						}
						else
						{
							out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Raios .__.'); window.location='Bank-iTo.jsp'\"></body></html>");
						}
					}
				}
				catch (Exception e) 
				{
					out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Verifique que los datos ingresados sean correctos.'); window.location='Bank-iTo.jsp'\"></body></html>");
				}
			}
			else
			{
				out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('La cuenta "+cuenta+" est� inactiva.'); window.location='Bank-iTo.jsp'\"></body></html>");
			}
		} 
		catch (Exception e) 
		{
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('La cuenta "+cuenta+" no existe.'); window.location='Bank-iTo.jsp'\"></body></html>");
		} 
	}

}

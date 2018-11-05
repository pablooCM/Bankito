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
						ConsultaSaldoCambioMoneda consulta = new ConsultaSaldoCambioMoneda(cuentaInt, pinEncriptado);
						double saldo = (double) consulta.consultarBaseDatos();
						TipoCambio cambio = new TipoCambio();
						double compra = cambio.getCompra();
						out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Estimado usuario, el saldo actual de su cuenta es "+saldo+" dólares. Para esta conversión se utilizó el tipo de cambio del dólar, precio de compra. [Según el BCCR, el tipo de cambio de compra del dólar de hoy es: "+compra+"]'); window.location='Bank-iTo.jsp'\"></body></html>");
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

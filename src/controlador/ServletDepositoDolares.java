package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaAccesoaDatos.BaseDatos;
import logicaIntegracion.EnviarMail;
import logicaIntegracion.TipoCambio;

/**
 * Servlet implementation class ServletDepositoDolares
 */
@WebServlet("/ServletDepositoDolares")
public class ServletDepositoDolares extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDepositoDolares() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
        String cuenta = request.getParameter("cuenta").toString();
        String correo = request.getSession().getAttribute("user").toString();
        
		double montoDolares = Double.parseDouble(request.getParameter("monto").toString());
		
		
		TipoCambio servicioTipoCambio = new TipoCambio();
		double compra = servicioTipoCambio.getCompra();
		double montoColones = montoDolares*compra;
				
		BaseDatos con = new BaseDatos();
		
		PrintWriter out = response.getWriter();
		try 
		{
			double comision = (montoColones*0.02);
			boolean valor = con.insertarDeposito(Integer.parseInt(cuenta), montoColones, comision);
			
			if(valor==true)
			{
				String mensaje = "Estimado usuario, se han recibido correctamente"+ montoDolares +" dólares. " + 
						"[Según el BCCR, el tipo de cambio de compra del dólar de hoy es:"+compra+"] " + 
						"[El monto equivalente en colones es"+ montoColones +"]" + 
						"[El monto real depositado a su cuenta"+ cuenta +"es de "+ (montoColones-comision) +" colones] " + 
						"[El monto cobrado por concepto de comisión fue de "+comision+" colones, que " + 
						"fueron rebajados automáticamente de su saldo actual]";
				
				EnviarMail mail = EnviarMail.getMail();
				if(mail.EnviarCorreo(correo, mensaje,"depósito",cuenta)==true)
				{
					out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('"+mensaje+"'); window.location='Bank-iTo.jsp'\"></body></html>");	
				} 
				else
				{
					System.out.println("error email");
				}
				
			}
			else
			{
				out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Fondos insuficientes.'); window.location='Bank-iTo.jsp'\"></body></html>");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Ocurrió un problema al realizar su retiro.'); window.location='Bank-iTo.jsp'\"></body></html>");
		}
	}

}

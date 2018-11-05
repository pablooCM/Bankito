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

/**
 * Servlet implementation class ServletRetiro
 */
@WebServlet("/ServletRetiro")
public class ServletRetiro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRetiro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
        String cuenta = request.getParameter("cuenta").toString();
        String correo = request.getSession().getAttribute("user").toString();
        
		double monto = Double.parseDouble(request.getParameter("monto").toString());
		
		BaseDatos con = new BaseDatos();
		
		PrintWriter out = response.getWriter();
		try 
		{
			double comision = (monto*0.02);
			boolean valor = con.insertarRetiro(Integer.parseInt(cuenta), monto, comision);
			
			if(valor==true)
			{
				String mensaje = "Estimado usuario, se han retirado correctamente "+monto+" colones. [El monto real retirado de su cuenta "+cuenta+" fue de "+(monto+comision)+" colones][El monto cobrado por concepto de comisión fue de "+ comision +" colones, que fueron rebajados automáticamente de su saldo actual]";
				
				EnviarMail mail = EnviarMail.getMail();
				if(mail.EnviarCorreo(correo, mensaje,"retiro",cuenta)==true)
				{
					out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('"+mensaje+"'); window.location='Bank-iTo.jsp'\"></body></html>");	
				} 
				else
				{
					out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Verifique que la cuenta para enviar notificaciones posee permisos por google para aplicaciones externas.'); window.location='Bank-iTo.jsp'\"></body></html>");
				}
				
			}
			else
			{
				out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Fondos insuficientes.'); window.location='Bank-iTo.jsp'\"></body></html>");
			}
		}
		catch (SQLException e) {
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Ocurrió un problema al realizar su retiro.'); window.location='Bank-iTo.jsp'\"></body></html>");
		}
	}

}

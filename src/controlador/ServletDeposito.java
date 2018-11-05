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
 * Servlet implementation class ServletDeposito
 */
@WebServlet("/ServletDeposito")
public class ServletDeposito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDeposito() {
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
			boolean valor = con.insertarDeposito(Integer.parseInt(cuenta), monto, comision);
			
			if(valor==true)
			{
				String mensaje = "Estimado usuario, se han recibido correctamente "+ monto +" colones. " + 
						"[El monto real depositado a su cuenta "+ cuenta +" es de "+ (monto-comision) +" colones] " + 
						"[El monto cobrado por concepto de comisión fue de "+ comision +" colones, que " + 
						"fueron rebajados automáticamente de su saldo actual]";
				
				EnviarMail mail = EnviarMail.getMail();
				if(mail.EnviarCorreo(correo, mensaje,"depósito",cuenta)==true)
				{
					out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('"+mensaje+"'); window.location='Bank-iTo.jsp'\"></body></html>");	
				} 
				else
				{
					out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Verifique que los datos ingresados sean correctos.'); window.location='Bank-iTo.jsp'\"></body></html>");
				}
				
			}
			else
			{
				out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Fondos insuficientes.'); window.location='Bank-iTo.jsp'\"></body></html>");
			}
		}
		catch (SQLException e) {
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Ocurrió un problema al realizar su depósito.'); window.location='Bank-iTo.jsp'\"></body></html>");
		}
	}

}

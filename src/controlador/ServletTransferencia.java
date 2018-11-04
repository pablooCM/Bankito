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
 * Servlet implementation class ServletTransferencia
 */
@WebServlet("/ServletTransferencia")
public class ServletTransferencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTransferencia() {
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
        String correo = request.getSession().getAttribute("user").toString();        
        String cuentaAcreditar = request.getParameter("cuentaA").toString();
        
		double monto = Double.parseDouble(request.getParameter("montoTransferir").toString());
		
		BaseDatos con = new BaseDatos();
		
		PrintWriter out = response.getWriter();
		try 
		{
			double comision = (monto*0.02);
			boolean valor = con.insertarTransferencia(Integer.parseInt(cuenta), monto, Integer.parseInt(cuentaAcreditar));
			
			String correoAcreditar = con.selectCorreo(Integer.parseInt(cuentaAcreditar));
			if(valor==true)
			{
				String mensaje = "Estimado usuario, la transferencia de fondos se ejecutó satisfactoriamente. " + 
						"El monto retirado de la cuenta origen: "+cuenta+" y depositado en la cuenta destino: "+cuentaAcreditar+" es "+monto+"colones." + 
						"[El monto cobrado por concepto de comisión a la cuenta origen fue de "+comision+" colones, que fueron rebajados automáticamente de su saldo actual]";
				
				EnviarMail mail = EnviarMail.getMail();
				if(mail.EnviarCorreo(correo, mensaje,"retiro",cuenta)==true && mail.EnviarCorreo(correoAcreditar, mensaje,"deposito",cuenta)==true)
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
			e.printStackTrace();
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Ocurrió un problema al realizar su retiro.'); window.location='Bank-iTo.jsp'\"></body></html>");
		}
	}
}

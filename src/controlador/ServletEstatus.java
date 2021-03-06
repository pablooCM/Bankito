package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaDeNegocios.ConsultaEstatusCuenta;

/**
 * Servlet implementation class ServletEstatus
 */
@WebServlet("/ServletEstatus")
public class ServletEstatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEstatus() {
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
				
		PrintWriter out = response.getWriter();
		try 
		{
			ConsultaEstatusCuenta consulta = new ConsultaEstatusCuenta(Integer.parseInt(cuenta));
			String estatus = consulta.getEstatusCuenta();
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('La cuenta n�mero "+cuenta+" tiene estatus de "+ estatus+".'); window.location='Bank-iTo.jsp'\"></body></html>");
		}
		catch (Exception e)
		{
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('La cuenta n�mero "+cuenta+" no existe.'); window.location='Bank-iTo.jsp'\"></body></html>");
		}
	}

}

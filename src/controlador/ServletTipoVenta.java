package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaIntegracion.TipoCambio;

/**
 * Servlet implementation class ServletTipoVenta
 */
@WebServlet("/ServletTipoVenta")
public class ServletTipoVenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
    */
    public ServletTipoVenta() {
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
		PrintWriter out = response.getWriter();	

		TipoCambio servicioTipoCambio = new TipoCambio();
		double venta = servicioTipoCambio.getVenta();
		
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Tipo de cambio de venta hoy "+sqlDate+", es de "+venta+" colones.'); window.location='Bank-iTo.jsp'\"></body></html>");
	}
}
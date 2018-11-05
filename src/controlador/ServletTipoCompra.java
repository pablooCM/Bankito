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
 * Servlet implementation class ServletTipoCompra
 */
@WebServlet("/ServletTipoCompra")
public class ServletTipoCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
    */
    public ServletTipoCompra() {
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
		double compra = servicioTipoCambio.getCompra();
		
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Tipo de cambio de compra hoy "+sqlDate+", es de "+compra+" colones.'); window.location='Bank-iTo.jsp'\"></body></html>");
	}
}
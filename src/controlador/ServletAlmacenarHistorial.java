package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaAccesoaDatos.BaseDatos;
/**
 * Servlet implementation class ServletAlmacenarHistorial
 */
@WebServlet("/ServletAlmacenarHistorial")
public class ServletAlmacenarHistorial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlmacenarHistorial() {
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
		String fecha = request.getParameter("fecha").toString();
		String hora = request.getParameter("horaInicio");
		String accion = request.getParameter("accion").toString();
		
		BaseDatos con = new BaseDatos();

		PrintWriter out = response.getWriter();	
		SimpleDateFormat availTime = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat availDate = new SimpleDateFormat("yyyy-MM-dd");
		
		java.util.Date newHora;
		java.util.Date newFecha;
		try 
		{
			String correo = con.selectLogin();
			String nombre = con.selectNombreDuenno(correo);
			int idDuenno = con.selectIdDueno(nombre);
			
			newHora = availTime.parse(hora);
			java.sql.Time sqlHora = new java.sql.Time(newHora.getTime());
			
			newFecha = availDate.parse(fecha);
			java.sql.Date sqlFecha = new java.sql.Date(newFecha.getTime());
			
			
			con.insertarHistorial(sqlFecha, sqlHora, accion, idDuenno);
			
			out.println("<html><head></head><title>Bank-iTo</title><body onload=\"alert('Se ha registrado la acción.'); window.location='Bank-iTo.jsp'\"></body></html>");
		} 
		catch (Exception e) 
		{
			e.getStackTrace();
		}

	}

}

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

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	doPost(request, response);
	}
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String correo = request.getParameter("correo").toString();
		String contrasenna= request.getParameter("contrasenna").toString();
		
		BaseDatos con = new BaseDatos();
		String user = null;
		try 
		{
			user = con.selectLogin(correo, contrasenna);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (user != null )
		{
			request.getSession().setAttribute("user", user);            
		    response.sendRedirect("Bank-iTo.jsp");
		}
		else
		{
			PrintWriter out = response.getWriter();
			out.print("<script type= 'text/javascript'>");
			out.print("alert('Verifique que los datos ingresados correspondan con algún usuario previamente registrado');");
			out.print("location='login.jsp';");
			out.print("</script>");
			response.sendRedirect("login.jsp");
		}
	}

}

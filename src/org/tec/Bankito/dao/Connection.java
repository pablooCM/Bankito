package org.tec.Bankito.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
	private static Connection instancia= new Connection();
	
	
	private Connection() {
		String url = "jdbc:sqlserver://bankitodb.database.windows.net:1433;database=bankitoDB";		
		String user = "LauraCarvajal@bankitodb";
		String password = "Laura0410";                                                          
		Statement statement;	
			try 
			{
				Class.forName("com.microsoft.sqlserver");
				// Create the connection using the IBM Data Server Driver for JDBC and SQLJ
				this.instancia = (Connection) DriverManager.getConnection (url, user, password);     
				// Commit changes manually
				((java.sql.Connection) this.instancia).setAutoCommit(false);
			} 
			catch (ClassNotFoundException e)
		    {
				System.err.println("Could not load JDBC driver");
				System.out.println("Exception: " + e);
				e.printStackTrace();
			}
			catch(SQLException ex)                                                     
			{
				System.err.println("SQLException information");
				while(ex!=null) 
				{
					System.err.println ("Error msg: " + ex.getMessage());
					System.err.println ("SQLSTATE: " + ex.getSQLState());
					System.err.println ("Error code: " + ex.getErrorCode());
					ex.printStackTrace();
					ex = ex.getNextException(); // For drivers that support chained exceptions
				}
			}
		}

	public static Connection getInstance(){
		return instancia;
	}
}

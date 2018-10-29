package org.tec.Bankito.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;



public class BaseDatos {
	Conexion con= Conexion.getInstance();
	
	public BaseDatos() {
		
	}
	public void insertarCuenta(String pin,String estatus, Date fechaCreacion, double saldo) throws SQLException {
	String query="insert into cuenta(pin, estatus,fechaCreacion,saldo) values('"+pin+"','"+estatus+"','"+fechaCreacion+","+saldo+")";	
	EjecutarQuery(query);
	}
	public void insertarDuenno(String nombre, String correo, String telefono, String password)  {
	try {
		String query="insert into duenno(nombre,correo,telefono, password) values('"+nombre+"','"+correo+"','"+telefono+"','"+password+"')";	
		Statement stmt;
		
			stmt = con.getConnection().createStatement();
		System.out.println(query);
		stmt.executeUpdate(query);
		stmt.close();
		
	} catch (SQLException e) {
		System.out.println("El usuario ya existe");
	}}
	public void insertarDeposito(int numero, double monto) throws SQLException {
		String query="insert into deposito(numeroCuenta,monto) values("+numero+","+monto+")";	
		EjecutarQuery(query);
	}
	public void insertarDepositoCambioMoneda(int numero,double montoD, double montoC, double tipoC) throws SQLException {
		String query="insert into depositoCambioMoneda(numeroCuenta, montoDolares,montoColones,tipoCambio) values("+numero+","+montoD+","+montoC+","+tipoC+")";
		EjecutarQuery(query);
	}
	public void insertarRetiro(int numero, double monto) throws SQLException {
		String query="insert into retiro(numeroCuenta,monto) values("+numero+","+monto+")";	
		EjecutarQuery(query);
	}
	public void insertarCodigoVerificacion(String codigo) throws SQLException {
		String query="insert into codigoVerificacion(codigoVerficiacion) values('"+codigo+"')";
		EjecutarQuery(query);
	}
	public void insertarTransferencia(int numero,double monto,int numeroD) throws SQLException {
		String query="insert into transferencia(numeroCuenta, monto,numeroCuentaDestino) values("+numero+","+monto+","+numeroD+")";
		EjecutarQuery(query);
	}
	public void insertarDuennoCuenta(int numero, int duenno) throws SQLException {
		String query="insert into duenno_Cuenta(id_Cuenta,id_Duenno) values("+numero+","+duenno+")";
		EjecutarQuery(query);
	}
	private void eliminarCodigo() throws SQLException {
		String query="delete from codigoVerificacion";
		EjecutarQuery(query);
	}
	public void actualizarCorreo(String correo, String nombre) throws SQLException{
		String query="	UPDATE duenno SET correo ='"+correo+
			     "' WHERE nombre='"+nombre+"'";
		EjecutarQuery(query);
	}
	public void actualizarTelefono(String nombre, String correo, String telefono) throws SQLException {
		String query="	UPDATE duenno SET telefono ='"+telefono+
			     "' WHERE nombre='"+nombre+"' and correo='"+correo+"'";
		EjecutarQuery(query);}
	public void actualizarPin(String pin, int numeroCuenta) throws SQLException {
		String query="	UPDATE cuenta SET pin ='"+pin+
			     "' WHERE numeroCuenta="+numeroCuenta+"";
		EjecutarQuery(query);
	}
	public void actualizarSaldo(int numero, double saldo) throws SQLException {
		String query="	UPDATE cuenta SET saldo ="+saldo+
			     " WHERE numeroCuenta="+numero+"";
		EjecutarQuery(query);
	}
	public void selectIdDueno(String nombre) throws SQLException {
		String select="Select id_Duenno from duenno where nombre='"+nombre+"'";
		EjecutarSelect(select);
	}
	public void selectCorreo(int numero) throws SQLException {
		String select="Select correo from cuenta join duenno_Cuenta on numeroCuenta=id_Cuenta join duenno on duenno_Cuenta.id_Duenno=duenno.id_duenno where numeroCuenta="+numero;
		EjecutarSelect(select);
	}
	public void selectTelefono(int numero) throws SQLException {
		String select="Select telefono from cuenta join duenno_Cuenta on numeroCuenta=id_Cuenta join duenno on duenno_Cuenta.id_Duenno=duenno.id_duenno where numeroCuenta="+numero;
		EjecutarSelect(select);
	}
	public void selectPin(int numero) throws SQLException {
		String select="Select pin from cuenta where numeroCuenta="+numero;
		EjecutarSelect(select);
	}
	public void selectCodigo() throws SQLException {
		String select="Select * from codigoVerificacion";
		EjecutarSelect(select);
	}
	public ResultSet selectHistorial() throws SQLException {
		String select="Select * from Historial";
		ResultSet rs=EjecutarSelect(select);
		return rs;
	}
	public void EjecutarQuery(String query) throws SQLException {
		Statement stmt= con.getConnection().createStatement();
		System.out.println(query);
		stmt.executeUpdate(query);
		stmt.close();
	}
	public ResultSet EjecutarSelect(String query) throws SQLException {
		Statement stmt= con.getConnection().createStatement();
		ResultSet rs;
		rs= stmt.executeQuery(query);
		return rs;
	}

}

package logicaAccesoaDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;


public class BaseDatosYO {
	Conexion con;
	
	public BaseDatosYO() 
	{
		this.con = Conexion.getInstance();		
	}
	public void insertarCuenta(String nombreDuenno, String correo, String telefono, String password, String pin,String estatus, Date fechaCreacion, double saldo) throws SQLException {
	String query="insert into cuenta(pin, estatus,fechaCreacion,saldo) values('"+pin+"','"+estatus+"','"+fechaCreacion+"',"+saldo+")";
	EjecutarQuery(query);
	
	if(selectIdDueno(nombreDuenno)==0)
	{
		insertarDuenno(nombreDuenno, correo, telefono, password);
	}
	
	int numCuenta = selectIdCuenta(pin,estatus,fechaCreacion,saldo);
	int idDuenno = selectIdDueno(nombreDuenno);
	
	insertarDuennoCuenta(numCuenta,idDuenno);
	}
	
	private void insertarDuenno(String nombre, String correo, String telefono, String password) throws SQLException  {
		String query="insert into duenno(nombre,correo,telefono, password) values('"+nombre+"','"+correo+"','"+telefono+"','"+password+"')";	
		EjecutarQuery(query);
	}
	public boolean insertarDeposito(int numero, double monto, double comision) throws SQLException {
		double saldo = getSaldo(numero);
		double total = monto+comision;
		String query="insert into deposito(numeroCuenta,monto,comision) values("+numero+","+total+","+comision+")";	
		System.out.println(query);
		EjecutarQuery(query);
		
		actualizarSaldo(numero, saldo+monto-comision);
		return true;
	}
	
	public boolean insertarRetiro(int numero, double monto, double comision) throws SQLException {
		double saldo = getSaldo(numero);
		double total = monto+comision;
		System.out.println(saldo+">"+total);
		if(saldo>=total)
		{
			String query="insert into retiro(numeroCuenta,monto,comision) values("+numero+","+total+","+comision+")";
			System.out.println(query);
			EjecutarQuery(query);
			
			actualizarSaldo(numero, saldo-total);
			return true;
		}			
		return false;
	}
		
	public double getSaldo(int cuenta) throws SQLException
	{
		String select="Select saldo from cuenta where numeroCuenta= "+cuenta;
		ResultSet rs = EjecutarSelect(select);
		// Print all of the employee numbers to standard output device
		while (rs.next())
		{
			double saldo = Double.parseDouble(rs.getString(1));
			return saldo;
		}
		return 0;
	}
	public void insertarCodigoVerificacion(String codigo) throws SQLException {
		eliminarCodigo();
		
		String query="insert into codigoVerificacion(codigoVerficiacion) values('"+codigo+"')";
		EjecutarQuery(query);
	}
	public boolean insertarTransferencia(int numero,double monto,int numeroD) throws SQLException {
		String query="insert into transferencia(numeroCuenta, monto,numeroCuentaDestino) values("+numero+","+monto+","+numeroD+")";
		if (insertarRetiro(numero,monto, (monto*0.02))==true && insertarDeposito(numeroD,monto,0)==true)
		{
			EjecutarQuery(query);
			return true;
		}
		return false;
	}
	
	private void insertarDuennoCuenta(int numero, int duenno) throws SQLException {
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
	
	private void actualizarSaldo(int numero, double saldo) throws SQLException {
		String query="	UPDATE cuenta SET saldo ="+saldo+
			     " WHERE numeroCuenta="+numero+"";
		EjecutarQuery(query);
	}

	//Esta funci�n s�lo se utiliza al crear la cuenta.
	public int selectIdCuenta(String pin,String estatus, Date fechaCreacion, double saldo) throws SQLException {
		String select="Select NUMEROCUENTA from CUENTA where PIN='"+pin+"' and ESTATUS='"+estatus
						+"' and FECHACREACION='"+fechaCreacion
						+"' and SALDO='"+saldo+"'";
		ResultSet rs = EjecutarSelect(select);
		// Print all of the employee numbers to standard output device
		while (rs.next())
		{
			int correoR = Integer.parseInt(rs.getString(1));
			return correoR;
		}
		return 0;
	}
	
	public int selectCuenta(String cuenta, String pin) throws SQLException {
		String select="Select NUMEROCUENTA from cuenta where NUMEROCUENTA='"+cuenta+"' and PIN='"+pin+"'";
		ResultSet rs = EjecutarSelect(select);
		// Print all of the employee numbers to standard output device
		while (rs.next())
		{
			int id = Integer.parseInt(rs.getString(1));
			return id;
		}
		return 0;
	}
	
	public String selectPin(String cuenta) throws SQLException {
		String select="Select PIN from cuenta where NUMEROCUENTA='"+cuenta+"'";
		ResultSet rs = EjecutarSelect(select);
		// Print all of the employee numbers to standard output device
		while (rs.next())
		{
			String pin = rs.getString(1);
			return pin;
		}
		return null;
	}
	
	public int selectIdDueno(String nombre) throws SQLException {
		String select="Select id_Duenno from duenno where nombre='"+nombre+"'";
		ResultSet rs = EjecutarSelect(select);
		// Print all of the employee numbers to standard output device
		while (rs.next())
		{
			int id = Integer.parseInt(rs.getString(1));
			return id;
		}
		return 0;
	}
	
	public String selectContrasennaDueno(String nombre) throws SQLException {
		String select="Select PASSWORD from duenno where nombre='"+nombre+"'";
		ResultSet rs = EjecutarSelect(select);
		// Print all of the employee numbers to standard output device
		while (rs.next())
		{
			String pass = rs.getString(1);
			return pass;
		}
		return null;
	}
	
	public String selectCorreo(int numero) throws SQLException {
		String select="Select correo from cuenta join duenno_Cuenta on numeroCuenta=id_Cuenta join duenno on duenno_Cuenta.id_Duenno=duenno.id_duenno where numeroCuenta="+numero;
		ResultSet rs = EjecutarSelect(select);
		// Print all of the employee numbers to standard output device
		while (rs.next())
		{
			String correo = rs.getString(1);
			return correo;
		}
		return null;
	}
	
	public String selectTelefono(String correo) throws SQLException {
		String select="Select telefono from duenno where correo= '"+correo+"'";
		ResultSet rs = EjecutarSelect(select);
		while (rs.next())
		{
			String telefono = rs.getString(1);
			return telefono;
		}
		return null;
	}
	
	public void selectPin(int numero) throws SQLException {
		String select="Select pin from cuenta where numeroCuenta="+numero;
		EjecutarSelect(select);
	}
	
	public String selectCodigo() throws SQLException {
		String select="Select * from codigoVerificacion";
		ResultSet rs = EjecutarSelect(select);
		while (rs.next())
		{
			String codigo = rs.getString(1);
			return codigo;
		}
		return null;
	}
	
	public ResultSet selectHistorial() throws SQLException {
		String select="Select * from Historial";
		ResultSet rs=EjecutarSelect(select);
		return rs;
	}
	

	public String selectNombreDuenno(String correo) throws SQLException {
		String select="Select NOMBRE from DUENNO where CORREO='"+correo+"'";
		ResultSet rs = EjecutarSelect(select);
		// Print all of the employee numbers to standard output device
		while (rs.next())
		{
			String nombre = rs.getString(1);
			return nombre;
		}
		return null;
	}
	
	
	public String selectLogin(String correo, String contrasenna) throws SQLException {
		String select="Select CORREO,PASSWORD from DUENNO where CORREO='"+correo+"' and PASSWORD='"+contrasenna+"'";
		ResultSet rs = EjecutarSelect(select);
		// Print all of the employee numbers to standard output device
		while (rs.next())
		{
			String correoR = rs.getString(1);
			return correoR;
		}
		return null;
	}
	
	public String selectEstatus(int cuenta) throws SQLException {
		String select="Select estatus from cuenta where NUMEROCUENTA="+cuenta;
		ResultSet rs = EjecutarSelect(select);
		// Print all of the employee numbers to standard output device
		while (rs.next())
		{
			String estatus = rs.getString(1);
			return estatus;
		}
		return null;
	}
	
	public void EjecutarQuery(String query) throws SQLException {
		Statement stmt= con.getConnection().createStatement();
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
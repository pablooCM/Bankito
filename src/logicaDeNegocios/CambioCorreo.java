package logicaDeNegocios;

<<<<<<< HEAD
public class CambioCorreo implements IActualizacion{
	private int numeroCuenta;
	private String pin;
	private String telefono;
	 
	public CambioCorreo(int pNumeroCuenta, String pPin, String pTelefono) {
		numeroCuenta=pNumeroCuenta;
		pin=pPin;
		telefono=pTelefono;
		 
=======
import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatos;

public class CambioCorreo implements IRegistro{

	private String correo; 
	private String correoO;
	public CambioCorreo(String correo) {
		this.correo=correo;
>>>>>>> a73a6277ac80913d0060656af480b545ae39d351
	}

	@Override
<<<<<<< HEAD
	public void actualizarBaseDatos() {
		// TODO Auto-generated method stub
=======
	public void registrarEnBaseDatos() throws SQLException {
		BaseDatos bs= new BaseDatos();
		bs.actualizarCorreo(correo, correoO);
>>>>>>> a73a6277ac80913d0060656af480b545ae39d351
		
	}

	

}

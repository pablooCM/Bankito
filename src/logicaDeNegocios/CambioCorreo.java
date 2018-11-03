package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatos;

public class CambioCorreo implements IRegistro{

	private String correo; 
	private String correoO;
	public CambioCorreo(String correo) {
		this.correo=correo;
	}
	@Override
	public void registrarEnBaseDatos() throws SQLException {
		BaseDatos bs= new BaseDatos();
		bs.actualizarCorreo(correo, correoO);
		
	}
	

}

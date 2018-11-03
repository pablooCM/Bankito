/**
 * 
 */
package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatosN;

/**
 * @author PabloCM
 *
 */
public class CambioTelefono implements IActualizacion{
	private String nombre;
	private String correo;
	private String telefono;
	
	public CambioTelefono(String pnombre, String pcorreo, String pTelefono) {
		this.nombre=pnombre;
		this.correo= pcorreo;
		this.telefono=pTelefono;
	
	}

	@Override
	public void actualizarBaseDatos() throws SQLException {
		BaseDatosN bs= new BaseDatosN();
		bs.actualizarTelefono(nombre, correo, telefono);
	}

	
	
}

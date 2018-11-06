/**
 * 
 */
package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatos;

/**
 * @author PabloCM
 *
 */
public class CambioTelefono implements IActualizacion{
	private String nombre;
	private String correo;
	private String telefono;
	
	public CambioTelefono(String pNombre, String pcorreo, String pTelefono) {
		this.nombre=pNombre;
		this.correo= pcorreo;
		this.telefono=pTelefono;
	
	}

	@Override
	public void actualizarBaseDatos() throws SQLException {
		BaseDatos bs= new BaseDatos();
		bs.actualizarTelefono(nombre, correo, telefono);
	}

	
	
}

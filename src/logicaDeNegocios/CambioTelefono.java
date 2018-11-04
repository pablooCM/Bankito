/**
 * 
 */
package logicaDeNegocios;

import java.sql.SQLException;

<<<<<<< HEAD
import logicaAccesoaDatos.BaseDatos;
=======
import logicaAccesoaDatos.BaseDatosN;
>>>>>>> 98eb02b7e420d8b3972fbe0b5223f32e65001354

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
<<<<<<< HEAD
		BaseDatos bs= new BaseDatos();
=======
		BaseDatosN bs= new BaseDatosN();
>>>>>>> 98eb02b7e420d8b3972fbe0b5223f32e65001354
		bs.actualizarTelefono(nombre, correo, telefono);
	}

	
	
}

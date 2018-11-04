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
public class CambioPin implements IActualizacion{
	private int numeroCuenta;
	private String pinCuenta;
	public CambioPin(int pNumeroCuenta, String pinCuenta) {
		this.numeroCuenta= pNumeroCuenta;
		this.pinCuenta=pinCuenta;
	}
	@Override
	public void actualizarBaseDatos() throws SQLException {
<<<<<<< HEAD
		BaseDatos bs= new BaseDatos();
=======
		BaseDatosN bs= new BaseDatosN();
>>>>>>> 98eb02b7e420d8b3972fbe0b5223f32e65001354
		bs.actualizarPin(pinCuenta, numeroCuenta);
		
	}

}

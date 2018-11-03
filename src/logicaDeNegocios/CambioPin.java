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
public class CambioPin implements IActualizacion{
	private int numeroCuenta;
	private String pinCuenta;
	public CambioPin(int pNumeroCuenta, String pinCuenta) {
		this.numeroCuenta= pNumeroCuenta;
		this.pinCuenta=pinCuenta;
	}
	@Override
	public void actualizarBaseDatos() throws SQLException {
		BaseDatosN bs= new BaseDatosN();
		bs.actualizarPin(pinCuenta, numeroCuenta);
		
	}

}

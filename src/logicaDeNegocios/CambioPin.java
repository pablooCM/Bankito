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
public class CambioPin implements IActualizacion{
	private int numeroCuenta;
	private String pinCuenta;
	public CambioPin(int pNumeroCuenta, String pPinCuenta) {
		this.numeroCuenta= pNumeroCuenta;
		this.pinCuenta=pPinCuenta;
	}
	@Override
	public void actualizarBaseDatos() throws SQLException {
		BaseDatos bs= new BaseDatos();
		bs.actualizarPin(pinCuenta, numeroCuenta);
		
	}

}

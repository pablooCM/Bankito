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
public class Deposito implements IRegistro {

	/* (non-Javadoc)
	 * @see logicaDeNegocios.IRegistro#registrarEnBaseDatos()
	 */
	private int numeroCuenta;
	private double monto;
	
	public Deposito(int pNumeroCuenta, double pMonto) {
		numeroCuenta=pNumeroCuenta;
		monto=pMonto;
	}
	@Override
	public void registrarEnBaseDatos() throws SQLException {
		BaseDatos nObjeto = new BaseDatos();
		nObjeto.insertarDeposito(numeroCuenta, monto);

	}

}

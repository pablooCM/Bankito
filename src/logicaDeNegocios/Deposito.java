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
	private double comision;
	
	public Deposito(int pNumeroCuenta, double pMonto,double pComision) {
		numeroCuenta=pNumeroCuenta;
		monto=pMonto;
		comision=pComision;
	}
	@Override
	public void registrarEnBaseDatos() throws SQLException {
		BaseDatos nObjeto = new BaseDatos();
		nObjeto.insertarDeposito(numeroCuenta, monto, comision);

	}

}

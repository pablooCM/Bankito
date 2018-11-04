/**
 * 
 */
package logicaDeNegocios;
import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatosN;


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
	public Object registrarEnBaseDatos() throws SQLException {
		BaseDatosN nObjeto = new BaseDatosN();
		nObjeto.insertarDeposito(numeroCuenta, monto, comision);
		return nObjeto;

	}

}

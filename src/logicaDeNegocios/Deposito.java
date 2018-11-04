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
<<<<<<< HEAD
	public void registrarEnBaseDatos() throws SQLException {
		BaseDatos nObjeto = new BaseDatos();
		nObjeto.insertarDeposito(numeroCuenta, monto, comision);
=======
	public Object registrarEnBaseDatos() throws SQLException {
		BaseDatosN nObjeto = new BaseDatosN();
		nObjeto.insertarDeposito(numeroCuenta, monto, comision);
		return nObjeto;
>>>>>>> 98eb02b7e420d8b3972fbe0b5223f32e65001354

	}

}

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
public class RetiroColones implements IRegistro{
	
	private int numeroCuenta;
	private String pin;
	private double monto;
	private double comision;
	
	public RetiroColones(int pNumeroCuenta, String pPin, double pMonto, double comision) {
		numeroCuenta=pNumeroCuenta;
		pin= pPin;
		monto=pMonto;
		this.comision=comision;
	}

	@Override
<<<<<<< HEAD
	public void registrarEnBaseDatos() throws SQLException {
		BaseDatos bs=new BaseDatos();
		bs.insertarRetiro(this.numeroCuenta,this.monto,this.comision);
=======
	public Object registrarEnBaseDatos() throws SQLException {
		BaseDatosN bs=new BaseDatosN();
		bs.insertarRetiro(this.numeroCuenta,this.monto,this.comision);
		return bs;
>>>>>>> 98eb02b7e420d8b3972fbe0b5223f32e65001354
		
	}

}

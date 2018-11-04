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
	public Object registrarEnBaseDatos() throws SQLException {
		BaseDatosN bs=new BaseDatosN();
		bs.insertarRetiro(this.numeroCuenta,this.monto,this.comision);
		return bs;
		
	}

}

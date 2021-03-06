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
public class Transferencia implements IRegistro{
	private int numeroCuentaOrigen;
	private String pin;
	private int monto;
	private int numeroCuentaDestino;
	
	public Transferencia(int pCuentaOrigen, String pPin, int pMonto, int pCuentaDestino) {
		numeroCuentaOrigen=pCuentaOrigen;
		pin= pPin;
		monto=pMonto;
		numeroCuentaDestino=pCuentaDestino;
	}

	@Override
	public void registrarEnBaseDatos() throws SQLException {
		BaseDatos nObjeto = new BaseDatos();
		nObjeto.insertarTransferencia(numeroCuentaOrigen, monto, numeroCuentaDestino);
		
	}

}

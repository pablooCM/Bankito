/**
 * 
 */
package logicaDeNegocios;

/**
 * @author PabloCM
 *
 */
public class RetiroColones implements IRegistro{
	
	private int numeroCuenta;
	private String pin;
	private int monto;
	
	public RetiroColones(int pNumeroCuenta, String pPin, int pMonto) {
		numeroCuenta=pNumeroCuenta;
		pin= pPin;
		monto=pMonto;
	}

	@Override
	public void registrarEnBaseDatos() {
		// TODO Auto-generated method stub
		
	}

}

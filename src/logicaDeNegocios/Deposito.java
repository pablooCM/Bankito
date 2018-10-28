/**
 * 
 */
package logicaDeNegocios;

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
	public void registrarEnBaseDatos() {
		// TODO Auto-generated method stub

	}

}

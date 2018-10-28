/**
 * 
 */
package logicaDeNegocios;

/**
 * @author PabloCM
 *
 */
public class RegistroPin implements IRegistro{
	private int numeroCuenta;
	private String pinCuenta;
	
	public RegistroPin(int pNumeroCuenta, String pPinCuenta) {
		numeroCuenta= pNumeroCuenta;
		pinCuenta=pPinCuenta;
	}
	@Override
	public void registrarEnBaseDatos() {
		// TODO Auto-generated method stub
		
	}

}

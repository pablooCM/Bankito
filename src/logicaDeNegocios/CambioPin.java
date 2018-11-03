/**
 * 
 */
package logicaDeNegocios;

/**
 * @author PabloCM
 *
 */
public class CambioPin implements IActualizacion{
	private int numeroCuenta;
	private String pinCuenta;
	public CambioPin(int pNumeroCuenta, String pPinCuenta) {
		numeroCuenta= pNumeroCuenta;
		pinCuenta=pPinCuenta;
	}


	@Override
	public void actualizarBaseDatos() {
		// TODO Auto-generated method stub
		
	}

}

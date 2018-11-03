/**
 * 
 */
package logicaDeNegocios;

/**
 * @author PabloCM
 *
 */
public class CambioTelefono implements IActualizacion{
	private int numeroCuenta;
	private String pin;
	private String telefono;
	
	public CambioTelefono(int pNumeroCuenta, String pPin, String pTelefono) {
		numeroCuenta=pNumeroCuenta;
		pin= pPin;
		telefono=pTelefono;
	}

	@Override
	public void actualizarBaseDatos() {
		// TODO Auto-generated method stub
		
	}

	
	
}

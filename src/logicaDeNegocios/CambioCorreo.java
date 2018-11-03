package logicaDeNegocios;

public class CambioCorreo implements IRegistro{
	private int numeroCuenta;
	private String pin;
	private String telefono;
	 
	public CambioCorreo(int pNumeroCuenta, String pPin, String pTelefono) {
		numeroCuenta=pNumeroCuenta;
		pin=pPin;
		telefono=pTelefono;
		 
	}
	@Override
	public void registrarEnBaseDatos() {
		// TODO Auto-generated method stub
		
	}
	

}

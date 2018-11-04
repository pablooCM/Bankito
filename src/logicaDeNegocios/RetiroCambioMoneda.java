package logicaDeNegocios;

public class RetiroCambioMoneda implements IRegistro{

	private int numeroCuenta;
	private String pin;
	private int montoDolares;
	private double montoColones;
	private double comision;
	
	public RetiroCambioMoneda(int pNumeroCuenta, String pPin, double pMonto, double pComision) {
		numeroCuenta=pNumeroCuenta;
		pin=pPin;
		montoColones=pMonto;
	}
	
	@Override
	public void registrarEnBaseDatos() {
		// TODO Auto-generated method stub
		
	}
	

}

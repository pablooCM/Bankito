/**
 * 
 */
package logicaDeNegocios;

/**
 * @author PabloCM
 *
 */
public class DepositoCambioMoneda implements IRegistro{
	private int numeroCuenta;
	private int montoDolares;
	private double montoColones;
	private double comision;
	
	public DepositoCambioMoneda(int pNumeroCuenta, double pMonto, double comision){
		numeroCuenta=pNumeroCuenta;
		montoColones=pMonto;
	}
	@Override
	public void registrarEnBaseDatos() {
		// TODO Auto-generated method stub
		
	}
	

}

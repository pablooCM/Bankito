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
	private double tipoCambio;
	
	public DepositoCambioMoneda(int pNumeroCuenta, double pMonto){
		numeroCuenta=pNumeroCuenta;
		montoColones=pMonto;
	}
	@Override
	public void registrarEnBaseDatos() {
		// TODO Auto-generated method stub
		
	}
	
	private void setTipoCambio(double pTipoCambio) {
		//TODO
	}
	
	private double convertidorDolaresaColones(int pMontoDolores) {
		//TODO
		return 0;
	}

}

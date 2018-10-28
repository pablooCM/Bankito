/**
 * 
 */
package logicaDeNegocios;

import dto.DTOCuenta;

/**
 * @author PabloCM
 *
 */
public class DirectorCuenta {
	private IConstructorCuenta constructor;


	public void setConstructor(IConstructorCuenta pConstructor) {
		constructor = pConstructor;
	}
	
	public Cuenta getRegistroPin(int pNumeroCuenta, String pPin) {
		return constructor.construirRegistroPin(pNumeroCuenta, pPin);
	}
	
	public Cuenta getDeposito(int pNumeroCuenta, int pMonto) {
		return constructor.construirDeposito(pNumeroCuenta, pMonto);
	}
	
	public Cuenta getDepositoCambioMoneda(int pNumeroCuenta, int pMonto) {
		return constructor.construirDepositoCambioMoneda(pNumeroCuenta, pMonto);
	}
	
	public Cuenta getRetiroColones(int pNumeroCuenta, String pPin, int pMonto) {
		return constructor.construirRetiroColones(pNumeroCuenta, pPin, pMonto);
	}
	
	public Cuenta getTransferencia(int pNumeroCuentaOrigen, String pPin, int pMonto, int pCuentaDestino) {
		return constructor.construirTransferencia(pNumeroCuentaOrigen, pPin, pMonto, pCuentaDestino);
	}
	
	public Cuenta getConsultaSaldo(int pNumeroCuenta, String pPin) {
		return constructor.construirConsultaSaldo(pNumeroCuenta, pPin);
	}
	
	public Cuenta getConsultaSaldoMonedaExtranjera(int pNumeroCuenta, String pPin) {
		return constructor.construirConsultaSaldoMonedaExtranjera(pNumeroCuenta, pPin);
	}
	
	public Cuenta getConsultaEstadoCuenta(int pNumeroCuenta, String pPin) {
		return constructor.construirConsultaEstadoCuenta(pNumeroCuenta, pPin);
	}
	
	public Cuenta getConsultaEstadoCuentaMonedaExtranjera(int pNumeroCuenta, String pPin) {
		return constructor.construirConsultaEstadoCUentaMonedaExtranjera(pNumeroCuenta, pPin);
	}
	
	public Cuenta getCambioTelefono(int pNumeroCuenta, String pPin, String pTelefono) {
		return constructor.construirCambioTelefono(pNumeroCuenta, pPin, pTelefono);
	}
	
	public Cuenta getCambioCorreo(int pNumeroCuenta, String pPin, String pCorreo) {
		return constructor.construirCambioCorreo(pNumeroCuenta, pPin, pCorreo);
	}
	public Cuenta getConsultaDatosCuenta(DTOCuenta pDatosCuenta) {
		return constructor.construirConsultaDatosCuenta(pDatosCuenta);
		
	}

}
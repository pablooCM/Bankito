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
	
	
	public Cuenta getDeposito(int pNumeroCuenta, double pMonto, double comision) {
		return constructor.construirDeposito(pNumeroCuenta, pMonto,comision);
	}
	
	
	public Cuenta getRetiroColones(int pNumeroCuenta, String pPin, double pMonto, double pComision) {
		return constructor.construirRetiroColones(pNumeroCuenta, pPin, pMonto,pComision);
	}
	
	public Cuenta getRetiroCambioMoneda(int pNumeroCuenta, String pPin, int pMonto, double pComision) {
		return constructor.construirRetiroCambioMoneda(pNumeroCuenta, pPin, pMonto, pComision);
	}
	
	public Cuenta getTransferencia(int pNumeroCuentaOrigen, String pPin, int pMonto, int pCuentaDestino) {
		return constructor.construirTransferencia(pNumeroCuentaOrigen, pPin, pMonto, pCuentaDestino);
	}
	
	public Cuenta getConsultaCantidadDebitosRetiros(int pNumeroCuenta) {
		return constructor.construirCantidadDebitosRetiros(pNumeroCuenta);
	}
	
	public Cuenta getConsultaSaldo(int pNumeroCuenta, String pPin) {
		return constructor.construirConsultaSaldo(pNumeroCuenta, pPin);
	}
	
	public Cuenta getConsultaSaldoMonedaExtranjera(int pNumeroCuenta, String pPin) {
		return constructor.construirConsultaSaldoMonedaExtranjera(pNumeroCuenta, pPin);
	}
	
	public Cuenta getConsultaCantidadDebitos(int pNumeroCuenta) {
		return constructor.construirConsultaCantidadDebitos(pNumeroCuenta);
	}
	
	public Cuenta getConsultaCantidadRetiros(int pNumeroCuenta) {
		return constructor.construirConsultaCantidadRetiros(pNumeroCuenta);
	}
	
	public Cuenta getConsultaComisionDebito(int pNumeroCuenta) {
		return constructor.construirConsultaComisionDebito(pNumeroCuenta);
	}
	
	public Cuenta getConsultaComisionRetiros(int pNumeroCuenta) {
		return constructor.construirConsultaComisionRetiros(pNumeroCuenta);
	}
	
	public Cuenta getConsultaComisionTotal(int pNumeroCuenta) {
		return constructor.construirConsultaComisionTotal(pNumeroCuenta);
	}
	
	public Cuenta getConsultaMontoDebitos(int pNumeroCuenta, String pPin) {
		return constructor.construirConsultaMontoDebitos(pNumeroCuenta, pPin);
	}
	
	public Cuenta getConsultaMontoRetiros(int pNumeroCuenta, String pPin) {
		return constructor.construirConsultaMontoRetiros(pNumeroCuenta, pPin);
	}
	
	public Cuenta getCambioPin(int pNumeroCuenta, String pPin) {
		return constructor.construirCambioPin(pNumeroCuenta, pPin);
	}
	
	public Cuenta getCambioTelefono(String pNombre, String pCorreo, String pTelefono) {
		return constructor.construirCambioTelefono(pNombre, pCorreo, pTelefono);
	}
	
	public Cuenta getCambioCorreo(String pCorreoActual, String pNuevoCorreo) {
		return constructor.construirCambioCorreo(pCorreoActual, pNuevoCorreo);
	}
	
}

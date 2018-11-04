package logicaDeNegocios;

import dto.DTOCuenta;

public interface IConstructorCuenta {
	
	public abstract Cuenta construirDeposito(int pNumeroCuenta, double pMonto, double pComision);
	public abstract Cuenta construirDepositoCambioMoneda(int pNumeroCuenta, int pMonto, double pComision);
	public abstract Cuenta construirRetiroColones(int pNumeroCuenta,String pPin, double pMonto, double pComision);
	public abstract Cuenta construirRetiroCambioMoneda(int pNumeroCuenta, String pPin, int pMonto, double pComision);
	public abstract Cuenta construirTransferencia(int pNumeroCuentaOrigen, String pPin, int pMonto, int pCuentaDestino);
	
	public abstract Cuenta construirCantidadDebitosRetiros(int pNumeroCuenta);
	public abstract Cuenta construirConsultaSaldo(int pNumeroCuenta, String pPin);
	public abstract Cuenta construirConsultaSaldoMonedaExtranjera(int pNumeroCuenta, String pPin);
	public abstract Cuenta construirConsultaCantidadDebitos(int pNumeroCuenta);
	public abstract Cuenta construirConsultaCantidadRetiros(int pNumeroCuenta);
	public abstract Cuenta construirConsultaComisionDebito(int pNumeroCuenta);
	public abstract Cuenta construirConsultaComisionRetiros(int pNumeroCuenta);
	public abstract Cuenta construirConsultaComisionTotal(int pNumeroCuenta);
	public abstract Cuenta construirConsultaMontoDebitos(int pNumeroCuenta, String pPin);
	public abstract Cuenta construirConsultaMontoRetiros(int pNumeroCuenta, String pPin);
	
	
	public abstract Cuenta construirCambioCorreo(String pCorreoActual, String pNuevoCorreo);
	public abstract Cuenta construirCambioTelefono(String pNombre, String correo, String pTelefono);
	public abstract Cuenta construirCambioPin(int pNumeroCuenta, String pinCuenta);
	
	
	
	

	
	
}

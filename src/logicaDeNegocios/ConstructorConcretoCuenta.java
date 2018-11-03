package logicaDeNegocios;

import dto.DTOCuenta;

public class ConstructorConcretoCuenta implements IConstructorCuenta{
	@Override
	public Cuenta construirDeposito(int pNumeroCuenta, double pMonto, double pComision) {
        IRegistro nuevoRegistro = new Deposito(pNumeroCuenta, pMonto, pComision);
        Cuenta cuenta = new Cuenta();
        cuenta.setRegistro(nuevoRegistro);
        return cuenta;
	}
	
	@Override
	public Cuenta construirDepositoCambioMoneda(int pNumeroCuenta, int pMonto, double pComision) {
        IRegistro nuevoRegistro = new DepositoCambioMoneda(pNumeroCuenta, pMonto, pComision);
        Cuenta cuenta = new Cuenta();
        cuenta.setRegistro(nuevoRegistro);
        return cuenta;
	}
	
	@Override
	public Cuenta construirRetiroColones(int pNumeroCuenta, String pPin, double pMonto, double pComision) {
		IRegistro nuevoRegistro = new RetiroColones(pNumeroCuenta, pPin, pMonto, pComision);
		Cuenta cuenta = new Cuenta();
		cuenta.setRegistro(nuevoRegistro);
		return cuenta;
	}
	
	@Override
	public Cuenta construirRetiroCambioMoneda(int pNumeroCuenta, String pPin, int pMonto, double pComision) {
		IRegistro nuevoRegistro = new RetiroCambioMoneda(pNumeroCuenta, pPin, pMonto, pComision);
		Cuenta cuenta = new Cuenta();
		cuenta.setRegistro(nuevoRegistro);
		return cuenta;
	}
	
	@Override
	public Cuenta construirTransferencia(int pNumeroCuentaOrigen, String pPin, int pMonto, int pCuentaDestino) {
		IRegistro nuevoRegistro = new Transferencia(pNumeroCuentaOrigen, pPin, pMonto, pCuentaDestino);
		Cuenta cuenta = new Cuenta();
		cuenta.setRegistro(nuevoRegistro);
		return cuenta;
	}
	
	@Override
	public Cuenta construirConsultaSaldo(int pNumeroCuenta, String pPin) {
		IConsulta nuevaConsulta = new ConsultaSaldo(pNumeroCuenta, pPin);
		Cuenta cuenta = new Cuenta();
		cuenta.setConsulta(nuevaConsulta);
		return cuenta;
	}
	
	@Override
	public Cuenta construirConsultaSaldoMonedaExtranjera(int pNumeroCuenta, String pPin) {
		IConsulta nuevaConsulta = new ConsultaSaldoCambioMoneda(pNumeroCuenta, pPin);
		Cuenta cuenta = new Cuenta();
		cuenta.setConsulta(nuevaConsulta);
		return cuenta;
	}

	@Override
	public Cuenta construirCambioPin(int pNumeroCuenta, String pinCuenta) {
        IActualizacion cambioRegistro = new CambioPin(pNumeroCuenta, pinCuenta);
        Cuenta cuenta = new Cuenta();
        cuenta.setActualizacion(cambioRegistro);
        return cuenta;
	}


	@Override
	public Cuenta construirCambioTelefono(String pNombre, String correo, String pTelefono) {
        IActualizacion cambioRegistro = new CambioTelefono(pNombre, correo, pTelefono);
        Cuenta cuenta = new Cuenta();
        cuenta.setActualizacion(cambioRegistro);
        return cuenta;
	}

	@Override
	public Cuenta construirCambioCorreo(String pCorreoActual, String pNuevoCorreo) {

        IActualizacion cambioRegistro = new CambioCorreo(pCorreoActual,pNuevoCorreo);
        Cuenta cuenta = new Cuenta();
        cuenta.setActualizacion(cambioRegistro);
        return cuenta;
	}








}

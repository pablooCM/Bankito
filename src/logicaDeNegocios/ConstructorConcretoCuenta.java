package logicaDeNegocios;

import dto.DTOCuenta;

public class ConstructorConcretoCuenta implements IConstructorCuenta{




	@Override
	public Cuenta construirCambioPin(int pNumeroCuenta, String pPin) {
        IActualizacion cambioRegistro = new CambioPin(pNumeroCuenta, pPin);
        Cuenta cuenta = new Cuenta();
        cuenta.setActualizacion(cambioRegistro);
        return cuenta;
	}

	@Override
	public Cuenta construirDeposito(int pNumeroCuenta, double pMonto, double pComision) {
        IRegistro nuevoRegistro = new Deposito(pNumeroCuenta, pMonto, pComision);
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
	public Cuenta construirCambioTelefono(int pNumeroCuenta, String pPin, String pTelefono) {
        IActualizacion cambioRegistro = new CambioTelefono(pNumeroCuenta, pPin, pTelefono);
        Cuenta cuenta = new Cuenta();
        cuenta.setActualizacion(cambioRegistro);
        return cuenta;
	}

	@Override
	public Cuenta construirCambioCorreo(int pNumeroCuenta, String pPin, String pCorreo) {
<<<<<<< HEAD
        IActualizacion cambioRegistro = new CambioCorreo(pNumeroCuenta, pPin, pCorreo);
        Cuenta cuenta = new Cuenta();
        cuenta.setActualizacion(cambioRegistro);
        return cuenta;
=======
		IRegistro nuevoRegistro = new CambioCorreo(pCorreo);
		Cuenta cuenta = new Cuenta();
		cuenta.setRegistro(nuevoRegistro);
		return cuenta;
>>>>>>> a73a6277ac80913d0060656af480b545ae39d351
	}


	@Override
	public Cuenta construirRetiroCambioMoneda(int pNumeroCuenta, String pPin, int pMonto) {
		IRegistro nuevoRegistro = new RetiroCambioMoneda(pNumeroCuenta, pPin, pMonto);
		Cuenta cuenta = new Cuenta();
		cuenta.setRegistro(nuevoRegistro);
		return cuenta;
	}



}

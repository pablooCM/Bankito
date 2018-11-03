package logicaDeNegocios;

import dto.DTOCuenta;

public class ConstructorConcretoCuenta implements IConstructorCuenta{




	@Override
	public Cuenta construirRegistroPin(int pNumeroCuenta, String pPin) {
        IRegistro nuevoRegistro = new RegistroPin(pNumeroCuenta, pPin);
        Cuenta cuenta = new Cuenta();
        cuenta.setRegistro(nuevoRegistro);
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
		IConsulta nuevaConsulta =new ConsultaSaldoCambioMoneda(pNumeroCuenta, pPin);
		Cuenta cuenta = new Cuenta();
		cuenta.setConsulta(nuevaConsulta);
		return cuenta;
	}

	@Override
	public Cuenta construirConsultaEstadoCuenta(int pNumeroCuenta, String pPin) {
		IConsulta nuevaConsulta =new ConsultaEstadoCuenta(pNumeroCuenta, pPin);
		Cuenta cuenta = new Cuenta();
		cuenta.setConsulta(nuevaConsulta);
		return cuenta;
	}

	@Override
	public Cuenta construirConsultaEstadoCUentaMonedaExtranjera(int pNumeroCuenta, String pPin) {
		IConsulta nuevaConsulta =new ConsultaEstadoCuentaCambioMoneda(pNumeroCuenta, pPin);
		Cuenta cuenta = new Cuenta();
		cuenta.setConsulta(nuevaConsulta);
		return cuenta;
	}

	@Override
	public Cuenta construirCambioTelefono(int pNumeroCuenta, String pPin, String pTelefono) {
		IRegistro nuevoRegistro = new CambioTelefono(pNumeroCuenta, pPin, pTelefono);
		Cuenta cuenta = new Cuenta();
		cuenta.setRegistro(nuevoRegistro);
		return cuenta;
	}

	@Override
	public Cuenta construirCambioCorreo(int pNumeroCuenta, String pPin, String pCorreo) {
		IRegistro nuevoRegistro = new CambioCorreo(pCorreo);
		Cuenta cuenta = new Cuenta();
		cuenta.setRegistro(nuevoRegistro);
		return cuenta;
	}

	@Override
	public Cuenta construirConsultaDatosCuenta(DTOCuenta pDatosCuenta) {
		IConsulta  nuevaConsulta = new ConsultaDatosCuenta(pDatosCuenta);
		Cuenta cuenta = new Cuenta();
		cuenta.setConsulta(nuevaConsulta);
		return cuenta;

	}

	@Override
	public Cuenta construirRetiroCambioMoneda(int pNumeroCuenta, String pPin, int pMonto) {
		IRegistro nuevoRegistro = new RetiroCambioMoneda(pNumeroCuenta, pPin, pMonto);
		Cuenta cuenta = new Cuenta();
		cuenta.setRegistro(nuevoRegistro);
		return cuenta;
	}



}

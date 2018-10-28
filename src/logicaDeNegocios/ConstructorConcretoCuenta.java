package logicaDeNegocios;

import dto.DTOCuenta;

public class ConstructorConcretoCuenta implements IConstructorCuenta{


	public Cuenta construirConsultaDatosCuenta(DTOCuenta pDatosCuenta) {
		IConsulta  nuevaConsulta = new ConsultaDatosCuenta(pDatosCuenta);
		Cuenta cuenta = new Cuenta();
		cuenta.setConsulta(nuevaConsulta);
		return cuenta;
	}

	@Override
	public Cuenta construirRegistroPin(int pNumeroCuenta, String pPin) {
        IRegistro nuevoRegistro = new RegistroPin(pNumeroCuenta, pPin);
        Cuenta cuenta = new Cuenta();
        cuenta.setRegistro(nuevoRegistro);
        return cuenta;
	}

	@Override
	public Cuenta construirDeposito(int pNumeroCuenta, int pMonto) {
        IRegistro nuevoRegistro = new Deposito(pNumeroCuenta, pMonto);
        Cuenta cuenta = new Cuenta();
        cuenta.setRegistro(nuevoRegistro);
        return cuenta;
	}

	@Override
	public Cuenta construirDepositoCambioMoneda(int pNumeroCuenta, int pMonto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuenta construirRetiroColones(int pNumeroCuenta, String pPin, int pMonto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuenta construirTransferencia(int pNumeroCuentaOrigen, String pPin, int pMonto, int pCuentaDestino) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuenta construirConsultaSaldo(int pNumeroCuenta, String pPin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuenta construirConsultaSaldoMonedaExtranjera(int pNumeroCuenta, String pPin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuenta construirConsultaEstadoCuenta(int pNumeroCuenta, String pPin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuenta construirConsultaEstadoCUentaMonedaExtranjera(int pNumeroCuenta, String pPin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuenta construirCambioTelefono(int pNumeroCuenta, String pPin, String pTelefono) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuenta construirCambioCorreo(int pNumeroCuenta, String pPin, String pCorreo) {
		// TODO Auto-generated method stub
		return null;
	}



}

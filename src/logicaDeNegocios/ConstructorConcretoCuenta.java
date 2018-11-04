package logicaDeNegocios;

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
	public Cuenta construirCantidadDebitosRetiros(int pNumeroCuenta) {
		IConsulta nuevaConsulta = new CantidadDebitosRetiros(pNumeroCuenta);
		Cuenta cuenta = new Cuenta();
		cuenta.setConsulta(nuevaConsulta);
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
	public Cuenta construirConsultaCantidadDebitos(int pNumeroCuenta) {
		IConsulta nuevaConsulta = new ConsultaCantidadDebitos(pNumeroCuenta);
		Cuenta cuenta = new Cuenta();
		cuenta.setConsulta(nuevaConsulta);
		return cuenta;
	}

	@Override
	public Cuenta construirConsultaCantidadRetiros(int pNumeroCuenta) {
		IConsulta nuevaConsulta = new ConsultaCantidadRetiros(pNumeroCuenta);
		Cuenta cuenta = new Cuenta();
		cuenta.setConsulta(nuevaConsulta);
		return cuenta;
	}

	@Override
	public Cuenta construirConsultaComisionDebito(int pNumeroCuenta) {
		IConsulta nuevaConsulta = new ConsultaComisionDebito(pNumeroCuenta);
		Cuenta cuenta = new Cuenta();
		cuenta.setConsulta(nuevaConsulta);
		return cuenta;
	}

	@Override
	public Cuenta construirConsultaComisionRetiros(int pNumeroCuenta) {
		IConsulta nuevaConsulta = new ConsultaComisionRetiros(pNumeroCuenta);
		Cuenta cuenta = new Cuenta();
		cuenta.setConsulta(nuevaConsulta);
		return cuenta;
	}

	@Override
	public Cuenta construirConsultaComisionTotal(int pNumeroCuenta) {
		IConsulta nuevaConsulta = new ConsultaComisionTotal(pNumeroCuenta);
		Cuenta cuenta = new Cuenta();
		cuenta.setConsulta(nuevaConsulta);
		return cuenta;
	}

	@Override
	public Cuenta construirConsultaMontoDebitos(int pNumeroCuenta, String pPin) {
		IConsulta nuevaConsulta = new ConsultaMontoDebitos(pNumeroCuenta, pPin);
		Cuenta cuenta = new Cuenta();
		cuenta.setConsulta(nuevaConsulta);
		return cuenta;
	}

	@Override
	public Cuenta construirConsultaMontoRetiros(int pNumeroCuenta, String pPin) {
		IConsulta nuevaConsulta = new ConsultaMontoRetiros(pNumeroCuenta, pPin);
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

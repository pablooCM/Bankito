package logicaDeNegocios;

import java.util.ArrayList;

import dto.DTOCuenta;

public class ConsultaSaldoCambioMoneda implements IConsulta{
	private int numeroCuenta;
	private String pin;
	private double tipoCambio;
	
	public ConsultaSaldoCambioMoneda(int pNumeroCuenta, String pPin) {
		numeroCuenta=pNumeroCuenta;
		pin=pPin;
	}

	@Override
	public ArrayList<DTOCuenta> consultarBaseDatos() {
		// TODO Auto-generated method stub
		return null;
	}
	private void setTipoCambio(double pTipoCambio) {
		// TODO
	}
	
	private double convertidorColonesaDolares(double pMonto) {
		// TODO
		return 0;
	}

}

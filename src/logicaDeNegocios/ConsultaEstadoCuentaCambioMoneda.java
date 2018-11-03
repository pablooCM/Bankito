package logicaDeNegocios;

import java.util.ArrayList;

import dto.DTOCuenta;

public class ConsultaEstadoCuentaCambioMoneda {
	private int numeroCuenta;
	private String pin;
	private double tipoCambio;
	
	public ConsultaEstadoCuentaCambioMoneda(int pNumeroCuenta, String pPin) {
		numeroCuenta=pNumeroCuenta;
		pin=pPin;
	}
	

}

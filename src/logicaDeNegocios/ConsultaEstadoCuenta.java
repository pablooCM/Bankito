package logicaDeNegocios;

import java.util.ArrayList;

import dto.DTOCuenta;

public class ConsultaEstadoCuenta implements IConsulta{
	private int numeroCuenta;
	private String pin;
	
	public ConsultaEstadoCuenta(int pNumeroCuenta, String pPin) {
		numeroCuenta=pNumeroCuenta;
		pin = pPin;
		
	}

	@Override
	public ArrayList<DTOCuenta> consultarBaseDatos() {
		// TODO Auto-generated method stub
		return null;
	}

}

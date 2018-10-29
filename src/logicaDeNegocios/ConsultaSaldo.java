package logicaDeNegocios;

import java.util.ArrayList;

import dto.DTOCuenta;

public class ConsultaSaldo implements IConsulta{
	private int numeroCuenta;
	private String pin;
	
	public ConsultaSaldo(int pNumeroCuenta, String pPin) {
		numeroCuenta= pNumeroCuenta;
		pin= pPin;
	}

	@Override
	public ArrayList<DTOCuenta> consultarBaseDatos() {
		// TODO Auto-generated method stub
		return null;
	}

}

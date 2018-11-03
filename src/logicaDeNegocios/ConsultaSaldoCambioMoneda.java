package logicaDeNegocios;

import java.sql.SQLException;
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
	public double consultarBaseDatos() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	
}

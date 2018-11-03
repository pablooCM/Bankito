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
<<<<<<< HEAD
=======
	@Override
	public ArrayList<DTOCuenta> consultarBaseDatos() {
		// TODO Auto-generated method stub
		return null;
	}
>>>>>>> dce4c48dba9db3030ac50cde684ced7ee93f2072
	

}

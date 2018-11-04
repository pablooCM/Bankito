package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatos;

public class ConsultaMontoRetiros implements IConsulta {
	private int numeroCuenta;
	private String pin;
	
	public ConsultaMontoRetiros(int pNumeroCuenta, String pPin) {
		numeroCuenta= pNumeroCuenta;
		pin= pPin;
	}

	@Override
	public Object consultarBaseDatos() throws SQLException {
		BaseDatos bs= new BaseDatos();
		double saldo =  bs.selectMontoRetiros(numeroCuenta);
		return saldo;
	}

}




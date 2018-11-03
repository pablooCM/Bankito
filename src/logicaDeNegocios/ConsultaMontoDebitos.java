package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatosN;

public class ConsultaMontoDebitos implements IConsulta {

	private int numeroCuenta;
	private String pin;
	
	public ConsultaMontoDebitos(int pNumeroCuenta, String pPin) {
		numeroCuenta= pNumeroCuenta;
		pin= pPin;
	}

	@Override
	public Object consultarBaseDatos() throws SQLException {
		BaseDatosN bs= new BaseDatosN();
		double saldo =  bs.selectMontoDebitos(numeroCuenta);
		return saldo;
	}

}


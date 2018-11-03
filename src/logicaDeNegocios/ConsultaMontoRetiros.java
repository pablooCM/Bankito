package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatosN;

public class ConsultaMontoRetiros implements IConsulta {
	private int numeroCuenta;
	private String pin;
	
	public ConsultaMontoRetiros(int pNumeroCuenta, String pPin) {
		numeroCuenta= pNumeroCuenta;
		pin= pPin;
	}

	@Override
	public Object consultarBaseDatos() throws SQLException {
		BaseDatosN bs= new BaseDatosN();
		double saldo =  bs.selectMontoRetiros(numeroCuenta);
		return saldo;
	}

}




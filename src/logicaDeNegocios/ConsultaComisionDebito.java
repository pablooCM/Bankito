package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatosN;

public class ConsultaComisionDebito implements IConsulta{
	private int numeroCuenta;

	
	public ConsultaComisionDebito(int pNumeroCuenta) {
		numeroCuenta= pNumeroCuenta;

	}

	@Override
	public Object consultarBaseDatos() throws SQLException {
		BaseDatosN bs= new BaseDatosN();
		double saldo =  bs.selectComisionDebitos(numeroCuenta);
		return saldo;
	}

}

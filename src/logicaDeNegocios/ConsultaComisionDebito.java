package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatos;

public class ConsultaComisionDebito implements IConsulta{
	private int numeroCuenta;

	
	public ConsultaComisionDebito(int pNumeroCuenta) {
		numeroCuenta= pNumeroCuenta;

	}

	@Override
	public Object consultarBaseDatos() throws SQLException {
		BaseDatos bs= new BaseDatos();
		double saldo =  bs.selectComisionDebitos(numeroCuenta);
		return saldo;
	}

}

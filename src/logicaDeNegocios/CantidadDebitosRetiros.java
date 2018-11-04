package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatos;

public class CantidadDebitosRetiros implements IConsulta {
	private int numeroCuenta;

	
	public CantidadDebitosRetiros(int pNumeroCuenta) {
		numeroCuenta= pNumeroCuenta;

	}

	@Override
	public Object consultarBaseDatos() throws SQLException {
		BaseDatos bs= new BaseDatos();
		int saldo =  bs.selectTotales(numeroCuenta);
		return saldo;
	}

}

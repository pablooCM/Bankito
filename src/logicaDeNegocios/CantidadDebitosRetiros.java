package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatosN;

public class CantidadDebitosRetiros implements IConsulta {
	private int numeroCuenta;

	
	public CantidadDebitosRetiros(int pNumeroCuenta) {
		numeroCuenta= pNumeroCuenta;

	}

	@Override
	public Object consultarBaseDatos() throws SQLException {
		BaseDatosN bs= new BaseDatosN();
		int saldo =  bs.selectTotales(numeroCuenta);
		return saldo;
	}

}

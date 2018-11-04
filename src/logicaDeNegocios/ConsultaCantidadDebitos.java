package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatos;

public class ConsultaCantidadDebitos implements IConsulta {
	private int numeroCuenta;

	
	public ConsultaCantidadDebitos(int pNumeroCuenta) {
		numeroCuenta= pNumeroCuenta;

	}

	@Override
	public Object consultarBaseDatos() throws SQLException {
		BaseDatos bs= new BaseDatos();
		int saldo =  bs.selectCantidadDebitos(numeroCuenta);
		return saldo;
	}

}




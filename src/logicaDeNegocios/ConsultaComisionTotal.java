package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatos;

public class ConsultaComisionTotal implements IConsulta{
	private int numeroCuenta;
	
	public ConsultaComisionTotal(int pNumeroCuenta) {
		numeroCuenta= pNumeroCuenta;
	
	}

	@Override
	public Object consultarBaseDatos() throws SQLException {
		BaseDatos bs= new BaseDatos();
		double comisiones=bs.selectComisionDebitos(numeroCuenta);
		return comisiones;
	}

}

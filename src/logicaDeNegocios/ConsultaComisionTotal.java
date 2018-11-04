package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatosN;

public class ConsultaComisionTotal implements IConsulta{
	private int numeroCuenta;
	
	public ConsultaComisionTotal(int pNumeroCuenta) {
		numeroCuenta= pNumeroCuenta;
	
	}

	@Override
	public Object consultarBaseDatos() throws SQLException {
		BaseDatosN bs= new BaseDatosN();
		double comisiones=bs.selectComisionDebitos(numeroCuenta);
		return comisiones;
	}

}

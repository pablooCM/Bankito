package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatosN;

public class ConsultaCantidadDebitos implements IConsulta {
	private int numeroCuenta;

	
	public ConsultaCantidadDebitos(int pNumeroCuenta) {
		numeroCuenta= pNumeroCuenta;

	}

	@Override
	public Object consultarBaseDatos() throws SQLException {
		BaseDatosN bs= new BaseDatosN();
		int saldo =  bs.selectCantidadDebitos(numeroCuenta);
		return saldo;
	}

}




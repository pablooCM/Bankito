package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatos;

public class ConsultaEstatusCuenta {
	private int numeroCuenta;
	private String estatus;
	
	public ConsultaEstatusCuenta(int pNumeroCuenta) {
		numeroCuenta=pNumeroCuenta;
	}
	
	public String getEstatusCuenta() throws SQLException {
		BaseDatos bs= new BaseDatos();
		this.estatus =  bs.selectEstatus(numeroCuenta);
		return estatus;
	}

}

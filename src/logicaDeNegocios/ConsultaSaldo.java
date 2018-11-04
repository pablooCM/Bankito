package logicaDeNegocios;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.DTOCuenta;
import logicaAccesoaDatos.BaseDatos;

public class ConsultaSaldo implements IConsulta{
	private int numeroCuenta;
	private String pin;
	
	public ConsultaSaldo(int pNumeroCuenta, String pPin) {
		numeroCuenta= pNumeroCuenta;
		pin= pPin;
	}

	@Override
	public Object consultarBaseDatos() throws SQLException {
		BaseDatos bs= new BaseDatos();
		double saldo =  bs.selectSaldoCuenta(numeroCuenta);
		return saldo;
	}

}

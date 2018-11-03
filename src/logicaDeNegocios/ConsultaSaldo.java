package logicaDeNegocios;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.DTOCuenta;
import logicaAccesoaDatos.BaseDatosN;

public class ConsultaSaldo implements IConsulta{
	private int numeroCuenta;
	private String pin;
	
	public ConsultaSaldo(int pNumeroCuenta, String pPin) {
		numeroCuenta= pNumeroCuenta;
		pin= pPin;
	}

	@Override
	public Object consultarBaseDatos() throws SQLException {
		BaseDatosN bs= new BaseDatosN();
		double saldo =  bs.selectSaldoCuenta(numeroCuenta);
		return saldo;
	}

}

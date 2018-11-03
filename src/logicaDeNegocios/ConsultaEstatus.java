package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatosN;
import logicaIntegracion.TipoCambio;

public class ConsultaEstatus implements IConsulta{
	private int numeroCuenta;
	private String pin;
	private double tipoCambio;
	TipoCambio tipo=null;
	public ConsultaEstatus(int pNumeroCuenta, String pPin) {
		numeroCuenta=pNumeroCuenta;
		pin=pPin;
	}

	@Override
	public Object consultarBaseDatos() throws SQLException {
		BaseDatosN bs= new BaseDatosN();
		String estatus =  bs.selectEstatus(numeroCuenta);
		return estatus;
	}

	
}



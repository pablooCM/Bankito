package logicaDeNegocios;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.DTOCuenta;
import logicaAccesoaDatos.BaseDatosN;
import logicaIntegracion.TipoCambio;

public class ConsultaSaldoCambioMoneda implements IConsulta{
	private int numeroCuenta;
	private String pin;
	private double tipoCambio;
	TipoCambio tipo=null;
	public ConsultaSaldoCambioMoneda(int pNumeroCuenta, String pPin) {
		numeroCuenta=pNumeroCuenta;
		pin=pPin;
	}

	@Override
	public Object consultarBaseDatos() throws SQLException {
		BaseDatosN bs= new BaseDatosN();
		double saldo =  bs.selectSaldoCuenta(numeroCuenta);
		double saldoD= saldo/tipo.getCompra();
		return saldoD;
	}

	
}

package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatos;
import logicaIntegracion.TipoCambio;

public class ConsultaSaldoCambioMoneda implements IConsulta{
	private int numeroCuenta;
	private String pin;
	private double tipoCambio;
	
	public ConsultaSaldoCambioMoneda(int pNumeroCuenta, String pPin) {
		numeroCuenta=pNumeroCuenta;
		pin=pPin;
	}

	@Override
	public Object consultarBaseDatos() throws SQLException {
		TipoCambio tipo= new TipoCambio();
		
		BaseDatos bs= new BaseDatos();
		
		double saldo =  bs.selectSaldoCuenta(numeroCuenta);
		this.tipoCambio= saldo/tipo.getCompra();
		return tipoCambio;
	}

	
}

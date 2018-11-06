package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatos;
import logicaIntegracion.TipoCambio;

public class ConsultaEstadoCuentaCambioMoneda implements IConsulta {
	private int numeroCuenta;
	private String pin;
	private double tipoCambio;
	
	public ConsultaEstadoCuentaCambioMoneda(int pNumeroCuenta, String pPin) {
		numeroCuenta=pNumeroCuenta;
		pin=pPin;
	}

	@Override
	public String consultarBaseDatos() throws SQLException {
		TipoCambio cambio = new TipoCambio();
		this.tipoCambio = cambio.getCompra();
		
		BaseDatos bs= new BaseDatos();
		
		int movimientosDebitos = bs.selectCantidadDebitos(numeroCuenta);
		int movimientosCreditos = bs.selectCantidadRetiros(numeroCuenta);
		int totales = bs.selectTotales(numeroCuenta);
		double saldoDebitos = bs.selectMontoDebitos(numeroCuenta)/this.tipoCambio;
		double saldoCreditos = bs.selectMontoRetiros(numeroCuenta)/this.tipoCambio;
		double saldoActual = bs.selectSaldoCuenta(numeroCuenta)/this.tipoCambio;
		this.pin = bs.selectPin(numeroCuenta);

		String msg = "La cuenta "+numeroCuenta+", con el pin cifrado: "+this.pin+", ha registrado un total de " +totales+" movimientos. "
				+ "De los cuales "+ movimientosCreditos +" son movimientos de crédito, para un total de "+saldoCreditos+" colones. "
				+ " y "+movimientosDebitos+ " son movimientos de débito, para un total de "+saldoDebitos+" colones. "
				+ "La cuenta posee actualmente: "+saldoActual+" dolares equivalentes según el tipo de cambio actual."
				+ "Tipo de cambio compra actual según el BCCR: "+this.tipoCambio+" colones";
		
		return msg;
	}
	
}

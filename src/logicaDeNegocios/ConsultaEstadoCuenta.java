package logicaDeNegocios;

import java.sql.SQLException;


import logicaAccesoaDatos.BaseDatos;


public class ConsultaEstadoCuenta implements IConsulta {
	private int numeroCuenta;
	private String pin;
	
	public ConsultaEstadoCuenta(int pNumeroCuenta, String pPin) {
		numeroCuenta=pNumeroCuenta;
		pin = pPin;
		
	}

	@Override
	public String consultarBaseDatos() throws SQLException {
		BaseDatos bs= new BaseDatos();
		
		int movimientosDebitos = bs.selectCantidadDebitos(numeroCuenta);
		int movimientosCreditos = bs.selectCantidadRetiros(numeroCuenta);
		int totales = bs.selectTotales(numeroCuenta);
		double saldoDebitos = bs.selectMontoDebitos(numeroCuenta);
		double saldoCreditos = bs.selectMontoRetiros(numeroCuenta);
		double saldoActual = bs.selectSaldoCuenta(numeroCuenta);
		this.pin = bs.selectPin(numeroCuenta);

		String msg = "La cuenta "+numeroCuenta+", con el pin cifrado: "+this.pin+", ha registrado un total de " +totales+" movimientos. "
				+ "De los cuales "+ movimientosCreditos +" son movimientos de crédito, para un total de "+saldoCreditos+" colones. "
				+ " y "+movimientosDebitos+ " son movimientos de débito, para un total de "+saldoDebitos+" colones. "
				+ "La cuenta posee actualmente: "+saldoActual+" colones.";
		
		return msg;
	}
}

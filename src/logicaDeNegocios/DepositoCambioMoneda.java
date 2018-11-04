/**
 * 
 */
package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatosN;
import logicaIntegracion.TipoCambio;


public class DepositoCambioMoneda implements IRegistro{
	private int numeroCuenta;
	private int montoDolares;
	private double montoColones;
	private double comision;
	private TipoCambio tipo=null;
	
	public DepositoCambioMoneda(int pNumeroCuenta, double pMonto, double pComision){
		numeroCuenta=pNumeroCuenta;
		montoColones=pMonto;
		this.comision=pComision;
		
	}
	@Override
	public Object registrarEnBaseDatos() throws SQLException {
		BaseDatosN bs=new BaseDatosN();
		bs.insertarDeposito(numeroCuenta, montoColones, comision);
		double dato=montoColones/tipo.getCompra();
		return dato;
		
	}
	

}

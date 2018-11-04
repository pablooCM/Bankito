package logicaDeNegocios;

import java.sql.SQLException;

import logicaAccesoaDatos.BaseDatosN;
import logicaIntegracion.TipoCambio;

public class RetiroCambioMoneda implements IRegistro{

	private int numeroCuenta;
	private String pin;
	private int montoDolares;
	private double montoColones;
	private double comision;
<<<<<<< HEAD
=======
	private TipoCambio tipo=null;
>>>>>>> 98eb02b7e420d8b3972fbe0b5223f32e65001354
	
	public RetiroCambioMoneda(int pNumeroCuenta, String pPin, double pMonto, double pComision) {
		numeroCuenta=pNumeroCuenta;
		montoColones=pMonto;
		
		this.comision=pComision;}
	
	@Override
	public Object registrarEnBaseDatos() throws SQLException {
		BaseDatosN bs=new BaseDatosN();
		bs.insertarRetiro(this.numeroCuenta,this.montoColones,this.comision);
		double dato=montoColones/tipo.getCompra();
		return dato;
		
		
		
	}
	

}

package logicaDeNegocios;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.DTOCuenta;
<<<<<<< HEAD
import logicaAccesoaDatos.BaseDatos;
=======
import logicaAccesoaDatos.BaseDatosN;
>>>>>>> 98eb02b7e420d8b3972fbe0b5223f32e65001354

public class ConsultaSaldo implements IConsulta{
	private int numeroCuenta;
	private String pin;
	
	public ConsultaSaldo(int pNumeroCuenta, String pPin) {
		numeroCuenta= pNumeroCuenta;
		pin= pPin;
	}

	@Override
	public Object consultarBaseDatos() throws SQLException {
<<<<<<< HEAD
		BaseDatos bs= new BaseDatos();
=======
		BaseDatosN bs= new BaseDatosN();
>>>>>>> 98eb02b7e420d8b3972fbe0b5223f32e65001354
		double saldo =  bs.selectSaldoCuenta(numeroCuenta);
		return saldo;
	}

}

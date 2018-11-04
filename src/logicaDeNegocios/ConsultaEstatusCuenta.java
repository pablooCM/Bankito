package logicaDeNegocios;

import java.sql.SQLException;

import dto.DTOCuenta;
<<<<<<< HEAD
import logicaAccesoaDatos.BaseDatos;
=======
import logicaAccesoaDatos.BaseDatosN;
>>>>>>> 98eb02b7e420d8b3972fbe0b5223f32e65001354

public class ConsultaEstatusCuenta {
	private int numeroCuenta;
	private String estatus;
	
	public ConsultaEstatusCuenta(int pNumeroCuenta) {
		numeroCuenta=pNumeroCuenta;
	}
	
	public String getEstatusCuenta(DTOCuenta pDatosCuenta) throws SQLException {
<<<<<<< HEAD
		BaseDatos bs= new BaseDatos();
=======
		BaseDatosN bs= new BaseDatosN();
>>>>>>> 98eb02b7e420d8b3972fbe0b5223f32e65001354
		String estatus =  bs.selectEstatus(numeroCuenta);
		return estatus;
	}

}

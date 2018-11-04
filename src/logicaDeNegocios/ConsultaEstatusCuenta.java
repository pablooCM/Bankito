package logicaDeNegocios;

import java.sql.SQLException;

import dto.DTOCuenta;
import logicaAccesoaDatos.BaseDatosN;

public class ConsultaEstatusCuenta {
	private int numeroCuenta;
	private String estatus;
	
	public ConsultaEstatusCuenta(int pNumeroCuenta) {
		numeroCuenta=pNumeroCuenta;
	}
	
	public String getEstatusCuenta(DTOCuenta pDatosCuenta) throws SQLException {
		BaseDatosN bs= new BaseDatosN();
		String estatus =  bs.selectEstatus(numeroCuenta);
		return estatus;
	}

}

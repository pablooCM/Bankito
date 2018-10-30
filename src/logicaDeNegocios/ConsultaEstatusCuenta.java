package logicaDeNegocios;

import dto.DTOCuenta;

public class ConsultaEstatusCuenta {
	private int numeroCuenta;
	private String estatus;
	
	public ConsultaEstatusCuenta(int pNumeroCuenta) {
		numeroCuenta=pNumeroCuenta;
	}
	
	public String getEstatusCuenta(DTOCuenta pDatosCuenta) {
		estatus = pDatosCuenta.getEstatus();
		return estatus;
	}

}

package logicaDeNegocios;

import dto.DTOCuenta;

public interface IConstructorCuenta {
	public abstract Cuenta construirRegistro(DTOCuenta pNumeroCuenta, DTOCuenta pPin);

	public abstract Cuenta construirConsultaDatosCuenta(DTOCuenta pDatosCuenta);
	
}

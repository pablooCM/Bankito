/**
 * 
 */
package logicaDeNegocios;

import dto.DTOCuenta;

/**
 * @author PabloCM
 *
 */
public class DirectorCuenta {
	private IConstructorCuenta constructor;

	public IConstructorCuenta getConstructor() {
		return constructor;
	}

	public void setConstructor(IConstructorCuenta pConstructor) {
		constructor = pConstructor;
	}
	
	public Cuenta getConsultaDatosCuenta(DTOCuenta pDatosCuenta) {
		return constructor.construirConsultaDatosCuenta(pDatosCuenta);
		
	}

}

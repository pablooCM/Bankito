/**
 * 
 */
package logicaDeNegocios;
import java.sql.Date;
import java.sql.SQLException;

import dto.DTOCuenta;
import logicaAccesoaDatos.BaseDatosN;

/**
 * @author PabloCM
 *
 */
public class RegistroCuenta {	
	public  static void registrarCuenta(DTOCuenta pDatosCuenta) throws SQLException {
	BaseDatosN bs=new BaseDatosN();
	bs.insertarCuenta(pDatosCuenta);
				
	}
}

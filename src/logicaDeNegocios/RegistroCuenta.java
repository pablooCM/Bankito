/**
 * 
 */
package logicaDeNegocios;
import java.sql.Date;
import java.sql.SQLException;

import dto.DTOCuenta;
import logicaAccesoaDatos.BaseDatos;

/**
 * @author PabloCM
 *
 */
public class RegistroCuenta {	
	public  static void registrarCuenta(DTOCuenta pDatosCuenta) throws SQLException {
	BaseDatos bs=new BaseDatos();
	bs.insertarCuenta(pDatosCuenta);
				
	}
}

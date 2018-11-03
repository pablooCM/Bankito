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
	
	
	
		
	public void registrarCuenta(DTOCuenta pDatosCuenta) throws SQLException {
	BaseDatos bs=new BaseDatos();
	bs.insertarCuenta(pDatosCuenta.getDuenio(), pDatosCuenta.getCorreo(), pDatosCuenta.getTelefono(), pDatosCuenta.getPassword(), pDatosCuenta.getPinCuenta(),pDatosCuenta.getEstatus(), pDatosCuenta.getFechaCreacion(),pDatosCuenta.getSaldo());
				
	}
}

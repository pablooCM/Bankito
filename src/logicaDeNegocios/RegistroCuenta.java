/**
 * 
 */
package logicaDeNegocios;
<<<<<<< HEAD
import java.sql.SQLException;

import dto.DTOCuenta;
import logicaAccesoaDatos.BaseDatos;
=======
import java.sql.Date;
import java.sql.SQLException;

import dto.DTOCuenta;
import logicaAccesoaDatos.BaseDatosN;
>>>>>>> 98eb02b7e420d8b3972fbe0b5223f32e65001354

/**
 * @author PabloCM
 *
 */
public class RegistroCuenta {	
<<<<<<< HEAD
	public  static void registrarCuenta(DTOCuenta pDatosCuenta, String contrasenna) throws SQLException {
	BaseDatos bs=new BaseDatos();
	bs.insertarCuenta(pDatosCuenta,contrasenna);
=======
	public  static void registrarCuenta(DTOCuenta pDatosCuenta) throws SQLException {
	BaseDatosN bs=new BaseDatosN();
	bs.insertarCuenta(pDatosCuenta);
>>>>>>> 98eb02b7e420d8b3972fbe0b5223f32e65001354
				
	}
}

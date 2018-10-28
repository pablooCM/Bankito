/**
 * 
 */
package logicaDeNegocios;

import java.util.ArrayList;
import java.util.Date;

import dto.DTOCuenta;

/**
 * @author PabloCM
 *
 */
public class ConsultaDatosCuenta implements IConsulta {
	private int numeroCuenta;
	private String pinCuenta;
	private String duenio;
	private String correo;
	private String telefono;
	private String estatus;
	private double saldo;
	private Date fechaCreacion;
	
	public ConsultaDatosCuenta(DTOCuenta pDatosCuenta) {
		numeroCuenta = pDatosCuenta.getNumeroCuenta();
		pinCuenta = pDatosCuenta.getPinCuenta();
		duenio = pDatosCuenta.getDuenio();
		correo = pDatosCuenta.getCorreo();
		telefono = pDatosCuenta.getTelefono();
		estatus = pDatosCuenta.getEstatus();
		saldo = pDatosCuenta.getSaldo();
		fechaCreacion = pDatosCuenta.getFechaCreacion();
	}

	@Override
	public ArrayList<DTOCuenta> consultarBaseDatos() {
		// TODO Auto-generated method stub
		return null;
	}

}

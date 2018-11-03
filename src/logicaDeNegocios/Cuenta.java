package logicaDeNegocios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dto.DTOCuenta;

public class Cuenta {
	
	private int numeroCuenta;
	private String pinCuenta;
	private String duenio;
	private String correo;
	private String telefono;
	private String estatus;
	private double saldo;
	private Date fechaCreacion;
	
	
	private IConsulta consulta;
	private IRegistro registro;
	private IActualizacion actualizacion;
	
	public Cuenta(DTOCuenta pDatosCuenta) {
		numeroCuenta = pDatosCuenta.getNumeroCuenta();
		pinCuenta = pDatosCuenta.getPinCuenta();
		duenio = pDatosCuenta.getDuenio();
		correo = pDatosCuenta.getCorreo();
		telefono = pDatosCuenta.getTelefono();
		estatus = pDatosCuenta.getEstatus();
		saldo = pDatosCuenta.getSaldo();
		fechaCreacion = pDatosCuenta.getFechaCreacion();
		
	}
	public Cuenta() {}
	
	public void registrar() throws SQLException {
		registro.registrarEnBaseDatos();
	}
	
	public double consultar() throws SQLException{
		return consulta.consultarBaseDatos();
	}
	
	public void actualizar() throws SQLException{
		actualizacion.actualizarBaseDatos();
	}
	public void setConsulta(IConsulta pConsulta){
		consulta= pConsulta;
	}
	
	public void setRegistro(IRegistro pRegistro) {
		registro = pRegistro;
	}
	public void setActualizacion(IActualizacion pActualizacion) {
		actualizacion=pActualizacion;
	}

}

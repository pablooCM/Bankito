/**
 * 
 */
package dto;

import java.sql.Date;

/**
 * @author PabloCM
 *
 */
public class DTOCuenta {
	private int numeroCuenta;
	private String duenio;
	private String correo;
	private String telefono;
	private String estatus;
	private double saldo;
	private Date fechaCreacion;
	private String pinCuenta;
	private String password;
	
	public DTOCuenta(int pNumeroCuenta, String pDuenio, String pCorreo, String pTelefono, String pEstatus, double pSaldo, Date pFechaCreacion, String pPinCuenta, String password) {
		numeroCuenta=pNumeroCuenta;
		this.duenio=pDuenio;
		this.correo=pCorreo;
		this.telefono=pTelefono;
		this.estatus=pEstatus;
		this.saldo=pSaldo;
		this.fechaCreacion=pFechaCreacion;
		this.pinCuenta=pPinCuenta;
		this.password=password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int pNumeroCuenta) {
		numeroCuenta = pNumeroCuenta;
	}

	public String getDuenio() {
		return duenio;
	}

	public void setDuenio(String pDuenio) {
		duenio = pDuenio;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String pCorreo) {
		correo = pCorreo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String pTelefono) {
		telefono = pTelefono;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String pEstatus) {
		estatus = pEstatus;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double pSaldo) {
		saldo = pSaldo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date pFechaCreacion) {
		fechaCreacion = pFechaCreacion;
	}

	public String getPinCuenta() {
		return pinCuenta;
	}

	public void setPinCuenta(String pPinCuenta) {
		pinCuenta = pPinCuenta;
	}
	
	
	
	

}
 
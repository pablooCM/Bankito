package dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author PabloCM
 *
 */
public class DTOBitacora {
	private String accion;
	private String correo;
	private LocalDateTime fecha;
	private LocalTime hora;
	
	public DTOBitacora(String pAccion, String pCorreo) {
		accion=pAccion;
		correo=pCorreo;
		fecha= LocalDateTime.now();
		hora= LocalTime.now();
		
	}
	
	public String getAccion() {
		return accion;
	}

	public void setAccion(String pAccion) {
		accion = pAccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String pCorreo) {
		correo = pCorreo;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha() {
		fecha = LocalDateTime.now();
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora() {
		hora = LocalTime.now();
	}

}

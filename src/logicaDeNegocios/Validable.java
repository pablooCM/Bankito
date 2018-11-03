package logicaDeNegocios;

public interface Validable 
{
	public boolean validarCorreoElectronico(String correo);
	public boolean validarTelefono(String telefono);
	public boolean validarPin(String pin);
}

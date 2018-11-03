package logicaDeNegocios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarDatos implements Validable {

	@Override
	public boolean validarCorreoElectronico(String correo) 
	{
		String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
			      "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
		Pattern pattern = Pattern.compile(emailPattern);
		Matcher matcher = pattern.matcher(correo);
		if (matcher.matches())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean validarTelefono(String telefono) 
	{
		if (telefono.length()==12)
		{
			return true;		
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public boolean validarPin(String pin) 
	{
		if (pin.length()==7)
		{
			return true;		
		}
		else
		{
			return false;
		}
	}

}

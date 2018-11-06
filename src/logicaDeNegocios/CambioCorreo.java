package logicaDeNegocios;
import java.sql.SQLException;
import logicaAccesoaDatos.BaseDatos;


public class CambioCorreo implements IActualizacion{
	private String nombre;
	private String nuevoCorreo;
	 
	public CambioCorreo(String pCorreoAnterior, String pNuevoCorreo) {
		nombre=pCorreoAnterior;
		nuevoCorreo=pNuevoCorreo;
	}

	@Override
	public void actualizarBaseDatos() throws SQLException {
		BaseDatos bs= new BaseDatos();
		bs.actualizarCorreo(nombre, nuevoCorreo);
	}
}



	



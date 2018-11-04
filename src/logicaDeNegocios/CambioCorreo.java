package logicaDeNegocios;
import java.sql.SQLException;
import logicaAccesoaDatos.BaseDatos;


public class CambioCorreo implements IActualizacion{
	private String correoAnterior;
	private String nuevoCorreo;
	 
	public CambioCorreo(String pCorreoAnterior, String pNuevoCorreo) {
		correoAnterior=pCorreoAnterior;
		nuevoCorreo=pNuevoCorreo;
	}

	@Override
	public void actualizarBaseDatos() throws SQLException {
		BaseDatos bs= new BaseDatos();
		bs.actualizarCorreo(correoAnterior, nuevoCorreo);
	}
}



	



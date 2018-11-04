package logicaDeNegocios;
import java.sql.SQLException;
<<<<<<< HEAD
import logicaAccesoaDatos.BaseDatos;
=======
import logicaAccesoaDatos.BaseDatosN;
>>>>>>> 98eb02b7e420d8b3972fbe0b5223f32e65001354


public class CambioCorreo implements IActualizacion{
	private String correoAnterior;
	private String nuevoCorreo;
	 
	public CambioCorreo(String pCorreoAnterior, String pNuevoCorreo) {
		correoAnterior=pCorreoAnterior;
		nuevoCorreo=pNuevoCorreo;
	}

	@Override
	public void actualizarBaseDatos() throws SQLException {
<<<<<<< HEAD
		BaseDatos bs= new BaseDatos();
=======
		BaseDatosN bs= new BaseDatosN();
>>>>>>> 98eb02b7e420d8b3972fbe0b5223f32e65001354
		bs.actualizarCorreo(correoAnterior, nuevoCorreo);
	}
}



	



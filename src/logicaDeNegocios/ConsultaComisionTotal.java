package logicaDeNegocios;

import java.sql.SQLException;

<<<<<<< HEAD
import logicaAccesoaDatos.BaseDatos;
=======
import logicaAccesoaDatos.BaseDatosN;
>>>>>>> 98eb02b7e420d8b3972fbe0b5223f32e65001354

public class ConsultaComisionTotal implements IConsulta{
	private int numeroCuenta;
	
	public ConsultaComisionTotal(int pNumeroCuenta) {
		numeroCuenta= pNumeroCuenta;
	
	}

	@Override
	public Object consultarBaseDatos() throws SQLException {
<<<<<<< HEAD
		BaseDatos bs= new BaseDatos();
=======
		BaseDatosN bs= new BaseDatosN();
>>>>>>> 98eb02b7e420d8b3972fbe0b5223f32e65001354
		double comisiones=bs.selectComisionDebitos(numeroCuenta);
		return comisiones;
	}

}

package logicaDeNegocios;

import java.sql.SQLException;

public interface IRegistro {
	public abstract Object registrarEnBaseDatos() throws SQLException;

}

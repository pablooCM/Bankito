package logicaDeNegocios;

import java.sql.SQLException;

public interface IRegistro {
	public abstract void registrarEnBaseDatos() throws SQLException;

}

package logicaDeNegocios;

import java.sql.SQLException;

import dto.DTOCuenta;

public interface IConsulta {
	public abstract Object consultarBaseDatos() throws SQLException;
}

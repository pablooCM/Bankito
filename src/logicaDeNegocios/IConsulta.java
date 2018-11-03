package logicaDeNegocios;

import java.sql.SQLException;

import dto.DTOCuenta;

public interface IConsulta {
	public abstract double consultarBaseDatos() throws SQLException;
}

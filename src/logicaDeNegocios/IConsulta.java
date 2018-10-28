package logicaDeNegocios;

import java.util.ArrayList;

import dto.DTOCuenta;

public interface IConsulta {
	public abstract ArrayList<DTOCuenta> consultarBaseDatos();
}

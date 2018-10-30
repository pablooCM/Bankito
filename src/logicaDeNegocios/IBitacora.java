package logicaDeNegocios;

import dto.DTOBitacora;

public interface IBitacora {
	public abstract void registrarAccion(DTOBitacora nuevaAccion);

}

package logicaDeNegocios;

import dto.DTOBitacora;

public class Posicional implements IBitacora{
	
    private final String RUTA; // TODO buscar la forma de hacerle el path para crear el archivo
    private static Posicional singletonPosicional;
	//TODO
    
    private Posicional() {}
    
    public static Posicional getSingletonBitacora()
    {
        if (singletonPosicional == null)
        {
            singletonPosicional = new Posicional();
        }
        return singletonPosicional;
    }

	@Override
	public void registrarAccion(DTOBitacora nuevaAccion) {
		// TODO Auto-generated method stub
		
	}

}

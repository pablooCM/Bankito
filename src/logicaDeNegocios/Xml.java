package logicaDeNegocios;

import dto.DTOBitacora;

public class Xml implements IBitacora{
	
    private final String RUTA; // TODO buscar la forma de hacerle el path para crear el archivo
    private static Xml singletonXml;
	//TODO
    private Xml()
    {
    }

    public static Xml getSingletonBitacora()
    {
        if (singletonXml == null)
        {
            singletonXml = new Xml();
        }
        return singletonXml;
    }

	@Override
	public void registrarAccion(DTOBitacora nuevaAccion) {
		// TODO Auto-generated method stub
		
	}
	

	

}

package logicaDeNegocios;

import dto.DTOBitacora;

public class Csv implements IBitacora{
	
    private final String RUTA; // TODO buscar la forma de hacerle el path para crear el archivo
    private static Csv singletonCsv;
	//TODO

    private Csv()
    {
    }

    public static Csv getSingletonBitacora()
    {
        if (singletonCsv == null)
        {
            singletonCsv = new Csv();
        }
        return singletonCsv;
    }

	@Override
	public void registrarAccion(DTOBitacora nuevaAccion) {
		// TODO Auto-generated method stub
		
	}

}

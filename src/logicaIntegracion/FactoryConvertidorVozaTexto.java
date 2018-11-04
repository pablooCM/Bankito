package logicaIntegracion;



public class FactoryConvertidorVozaTexto {
	/**
	 * Crea un nuevo objeto de tipo ConvertidorVozATexto.
	 * @return ConvertidorVozATexto.
	 */
	public static IVoz_Texto crearVoz_Texto(){
	    IVoz_Texto nuevoConvertidorVozATexto = new ConvertidorVozaTexto();
	    return nuevoConvertidorVozATexto;
	}

}

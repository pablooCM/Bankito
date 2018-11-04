package funcionesAcomodar;

import logicaDeNegocios.MD5;

public class main {

	
	public static void main(String[] args) 
	{
		/*
        //Crea el servicio del API
        TipoCambio servicioTipoCambio = new TipoCambio();
        
        //Obtiene el valor del precio de compra USD
        System.out.println(servicioTipoCambio.getCompra());
        
        //Obtiene el valor del precio de venta USD
        System.out.println(servicioTipoCambio.getVenta());
*/

		String hola = MD5.Encriptar("hola");
		
		System.out.println(hola);
		
		try {
			System.out.println(MD5.Desencriptar(hola));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}

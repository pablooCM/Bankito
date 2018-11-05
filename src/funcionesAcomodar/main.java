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

		String hola;
		try {
			hola = MD5.Desencriptar("6uDoKtVC6Mg=");	System.out.println(hola);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	}
}

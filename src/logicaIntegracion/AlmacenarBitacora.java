package logicaIntegracion;

import java.sql.ResultSet;
import java.util.ArrayList;

import logicaAccesoaDatos.BaseDatos;

public class AlmacenarBitacora{
	private ArrayList<Bitacora> bitacoras;
	
	public ResultSet rs;
	
	private static AlmacenarBitacora instancia;
	
	private AlmacenarBitacora() 
	{
		this.bitacoras = new ArrayList<Bitacora>();
	}

	public static AlmacenarBitacora getInstancia()
	{
		if (instancia!=null)
		{
			return instancia;
		}
		else 
		{
			instancia = new AlmacenarBitacora();	
			return instancia;
		}
	}
	public void agregarBitacora(Bitacora pBitacora) 
	{
		bitacoras.add(pBitacora);
	}
	
	private void actualizarBitacora() throws Exception {
		for (Bitacora bitacora: bitacoras) 
		{
			bitacora.update();
		}	
	}

	public void registrarAccion(int IdUsuario) throws Exception 
	{
		BaseDatos bs = new BaseDatos();
		
		this.rs = bs.selectHistorial(0);
		actualizarBitacora();
	}

}

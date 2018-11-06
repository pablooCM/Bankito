package logicaIntegracion;

import java.sql.ResultSet;
import java.util.ArrayList;

import logicaAccesoaDatos.BaseDatos;

public class AlmacenarBitacora{
	private ArrayList<Bitacora> bitacoras;
	private Bitacora csv;
	private Posicional posicional;
	private XML xml;
	public ResultSet rs;
	
	private static AlmacenarBitacora instancia;
	
	private AlmacenarBitacora() 
	{
		this.csv = new CSV(this);
		this.posicional = new Posicional(this);
		this.xml = new XML(this);
		this.bitacoras = new ArrayList<Bitacora>();
		this.agregarBitacora(csv);
		this.agregarBitacora(posicional);
		this.agregarBitacora(xml);
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
	public void agregarBitacora(Bitacora pBitacora) {
		bitacoras.add(pBitacora);
	}
	
	private void actualizarBitacora() throws Exception {
		for (Bitacora bitacora: bitacoras) {
			bitacora.update();
		}	
	}

	public void registrarAccion() throws Exception 
	{
		BaseDatos bs = new BaseDatos();
		
		this.rs = bs.selectHistorial();
		actualizarBitacora();
	}

}

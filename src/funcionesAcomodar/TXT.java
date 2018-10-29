package funcionesAcomodar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
public class TXT {
	public static File archivo;
		
	private void TXT() {
	this.archivo=new File("C:\\Bitacoras\\Persistencia.txt");}
	
	public File retornarArchivo() {
		if (archivo==null) {
			TXT();
			return archivo;
			}
			else {
				return archivo;
				}
			}
	
	public void EscribirTXT(String datos) {
	try {
	File archivoR=retornarArchivo();
	FileWriter escribir=new FileWriter(archivoR,true);
	escribir.write(datos);
	escribir.close();}
	catch(Exception e){
		System.out.println("Error al escribir");
		System.out.println(e);}}
	
	public void LeerTXT() {
	try{
		File folder = new File("C:\\Bitacoras");
		folder.mkdirs(); 
		FileReader lector=new FileReader("C:\\Bitacoras\\Persistencia.txt");
		BufferedReader contenido=new BufferedReader(lector);
		String texto;
		while((texto = contenido.readLine())!=null)
		{
			System.out.println(texto);
		}
	}
	catch(Exception e){
	System.out.println("Error al leer");}}
	}


	
	



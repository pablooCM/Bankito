package logicaIntegracion;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * <code>FactoryTipoCambio</code> realiza comunicaciones HTTP mediante el protocolo <code>GET</code>.
 * @author Hans Araya
 * @version 1.0
 */

public class FactoryTipoCambio {
	/**
	   * Devuelve un documento HTML a partir de una solicitud <code>HTTP GET</code>
	   * @param urlToRead con el URL a donde enviar la solicitud (incluido par�metros)
	   * @return <code>String</code> con el HTML dado por la solicitud HTTP GET
	   * @throws Exception
	   */
	  public static String crearTipoCambio(String pUrl) throws Exception 
	  {
	    StringBuilder result = new StringBuilder();
	    URL url = new URL(pUrl);
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    
	    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    String line;
	    while ((line = rd.readLine()) != null) 
	    {
	       result.append(line);
	    }
	    rd.close();
	    return result.toString();
	  }
	  

}

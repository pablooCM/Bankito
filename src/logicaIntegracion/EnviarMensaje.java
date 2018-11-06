package logicaIntegracion;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class EnviarMensaje 
{
	private String api;
	private String user;
	private String password;
	
	public EnviarMensaje() 
	{
		this.api = "https://api.labsmobile.com/json/send";
		this.user = "danycarse@estudiantec.cr";// "dvindas@estudiantec.cr  YtL10SJYJcjCXtS27hqVIZwK2xF93S5Q  "; 
		//pcorrales@estudiantec.cr  cp22zw87
		this.password = "mw89nb17";
	}
	
	public void enviarCodigo(String mensaje, String destinatario)
	{
		try
		{
			HttpResponse<String> response = Unirest.post(this.api)
					.header("Content-Type", "application/json")
					.basicAuth(this.user,this.password)
					.header("Cache-Control", "no-cache")
					.body("{\"message\":\"Bank-iTo informa que su código de verificación es: "+mensaje+"\", \"tpoa\":\"Sender\",\"recipient\":[{\"msisdn\":\""+destinatario+"\"}]}")
					.asString();
		} catch (UnirestException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
package Prueba;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class Prueba {
	public static void main(String[] args){
		String api = "https://api.labsmobile.com/json/send";
		String user = "dvindas@estudiantec.cr";
		String password = "YtL10SJYJcjCXtS27hqVIZwK2xF93S5Q";
		String mensaje = "HOLA";
		String destinatario = "+50685012099";
		
		try
		{
			HttpResponse<String> response = Unirest.post(api)
					.header("Content-Type", "application/json")
					.basicAuth(user,password)
					.header("Cache-Control", "no-cache")
					.body("{\"message\":\"Su código de verificación es: "+mensaje+"\", \"tpoa\":\"Sender\",\"recipient\":[{\"msisdn\":\""+destinatario+"\"}]}")
					.asString();
			System.out.println("gjkll");
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
}

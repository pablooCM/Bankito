package logicaIntegracion;
import java.io.File;

import com.google.gson.*;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

public class ConvertidorVozaTexto implements IVoz_Texto{
	private SpeechToText servicioVozATexto;
	private final static String NOMBREUSUARIO = "4e4fabc2-d41a-4b8b-bad5-cf3f46cc02c0";
	private final static String CONTRASENA = "woytt2WbtYks";
	/**
	 * Constructor de la clase.
	 */
	public ConvertidorVozaTexto()
	{
		servicioVozATexto =  new SpeechToText();
    	servicioVozATexto.setUsernameAndPassword(NOMBREUSUARIO,CONTRASENA);
	}
	
	
    private String obtenerTexto(String pResultado)//TODO hay que revisar que es lo que devuelve aca
    {
        
    	JsonElement jelement = new JsonParser().parse(pResultado);
	    JsonObject  jobject = jelement.getAsJsonObject();
	    
	    JsonArray jarray = jobject.getAsJsonArray("results");
	    jelement = jarray.get(0);
	    jobject = jelement.getAsJsonObject();
	    
	    JsonArray jarray2 = jobject.getAsJsonArray("alternatives");
	    jelement = jarray2.get(0);
	    jobject = jelement.getAsJsonObject();
	    String respuesta = jobject.get("transcript").toString();
	    respuesta = respuesta.substring(1, respuesta.length()-2).toString();
	    return respuesta;
    }


	@Override
	public String convertirVozTexto(File pArchivo) {
		RecognizeOptions opciones = new RecognizeOptions.Builder()
		.contentType("audio/wav")
		.model(SpeechModel.ES_ES_BROADBANDMODEL.getName())
		.continuous(true)
		.inactivityTimeout(500)
		.build();
	
		SpeechResults resultado = servicioVozATexto.recognize(pArchivo,opciones).execute();
	
		return obtenerTexto(resultado.toString());
	}

}

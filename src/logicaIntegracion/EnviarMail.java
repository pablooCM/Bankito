package logicaIntegracion;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * 
 * @author danyc
 *
 */
public class EnviarMail
{
	// Propiedades de la conexión
	private Properties props = new Properties();
	private MimeMessage message;
	private Session session;
	private static String user;
	private static String password;
	private Transport t;
	
	private static EnviarMail mail; 
	private EnviarMail(String user, String password)
	{
		this.props.setProperty("mail.smtp.host", "smtp.gmail.com");
		this.props.setProperty("mail.smtp.starttls.enable", "true");
		this.props.setProperty("mail.smtp.port", "587");
		this.props.setProperty("mail.smtp.auth", "true");
		
		EnviarMail.user = user;
		EnviarMail.password = password;
		
		// Preparamos la sesion
    	this.session = Session.getDefaultInstance(props);
    	
    	// Construimos el mensaje
    	this.message = new MimeMessage(session);
    	
    	try 
    	{
			this.t = this.session.getTransport("smtp");
		} 
    	catch (NoSuchProviderException e) 
    	{
			e.printStackTrace();
		}
	}
	
	public static EnviarMail getMail(String user, String password)
	{
		if (mail == null)
		{
			mail = new EnviarMail(user, password);
			return mail;
		}
		else
		{
			EnviarMail.user = user;
			EnviarMail.password = password;
			return mail;
		}
	}
    public boolean EnviarMail(String emisor, String receptor, int cuenta, double monto, String moneda, String accion)
    {
    	try
    	{
	    	this.message.setFrom(new InternetAddress(emisor));
	    	this.message.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));	    
	    	
	    	this.message.setSubject(accion.toUpperCase() + " DE SU CUENTA: " + String.valueOf(cuenta));
	    	this.message.setText("Estimado usuario, BANK-iTo informa un " + accion.toLowerCase() 
	    					   + " a su cuenta, por un monto de " + String.valueOf(monto) + " " + moneda.toLowerCase()+". Gracias.");

	    	this.t.connect(EnviarMail.user, EnviarMail.password);
	    	// Lo enviamos.	    
	    	this.t.sendMessage(message, message.getAllRecipients());
	    	
	    	// Cierre.
	    	this.t.close();
	    	return true;
    	}
    	catch( MessagingException e)
    	{
			e.printStackTrace();
    		return false;
		}
    }
}
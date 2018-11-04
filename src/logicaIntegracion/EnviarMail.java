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
	private EnviarMail()
	{
		this.props.setProperty("mail.smtp.host", "smtp.gmail.com");
		this.props.setProperty("mail.smtp.starttls.enable", "true");
		this.props.setProperty("mail.smtp.port", "587");
		this.props.setProperty("mail.smtp.auth", "true");

		// Preparamos la sesion
    	this.session = Session.getDefaultInstance(props);
    	EnviarMail.setDatos("bank.ito.crtec@gmail.com", "bankito123");
    	try 
    	{
			this.t = this.session.getTransport("smtp");
		} 
    	catch (NoSuchProviderException e) 
    	{
			e.printStackTrace();
		}
	}
	
	public static void setDatos(String user, String password)
	{
		EnviarMail.user = user;
		EnviarMail.password = password;
	}
	
	public static EnviarMail getMail()
	{
		if (mail == null)
		{
			mail = new EnviarMail();
			return mail;
		}
		else
		{
			return mail;
		}
	}
    public boolean EnviarCorreo(String receptor,String mensaje,String accion, String cuenta)
    {
    	try
    	{

        	// Construimos el mensaje
        	this.message = new MimeMessage(session);
        	
	    	this.message.setFrom(new InternetAddress(EnviarMail.user));
	    	this.message.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));	    
	    	
	    	this.message.setSubject(accion.toUpperCase() + " DE SU CUENTA: " + cuenta);
	    	this.message.setText(mensaje);
	    	
	    	System.out.println(EnviarMail.user +"  "+EnviarMail.password);
	    	this.t.connect("smtp.gmail.com", EnviarMail.user, EnviarMail.password);
	    	
	    	// Lo enviamos.	    
	    	this.t.sendMessage(message, message.getAllRecipients());
	    	
	    	// Cierre.
	    	this.t.close();
	    	return true;
    	}
    	catch( MessagingException e)
    	{
    		return false;
		}
    }
}
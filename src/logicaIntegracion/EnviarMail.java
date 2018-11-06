package logicaIntegracion;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
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
	private Properties props;
	private MimeMessage message;
	private Session session;
	private static String user;
	private static String password;
	
	private static EnviarMail mail; 
	
	private EnviarMail()
	{
		this.props = new Properties();
		// Assuming you are sending email through relay.jangosmtp.net
	     String host = "smtp.gmail.com";
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");


		// Preparamos la sesion
    	this.session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(EnviarMail.user, EnviarMail.password);
	   }
         });
    	
    	EnviarMail.setDatos("bank.ito.crtec@gmail.com", "bankito123");
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
	
    public String EnviarCorreo(String receptor,String mensaje,String accion, String cuenta)
    {
    	try
    	{
        	// Construimos el mensaje
        	this.message = new MimeMessage(this.session);
        	
	    	this.message.setFrom(new InternetAddress(EnviarMail.user));
	    	this.message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(receptor));	    
	    	
	    	this.message.setSubject(accion.toUpperCase() + " DE SU CUENTA: " + cuenta);
	    	
	    	this.message.setText(mensaje);
	    	
	    	System.out.println(EnviarMail.user +"  "+EnviarMail.password);
	    	
	    	Transport.send(message);

	    	return "SE ENVIÓ";
    	}
    	catch( MessagingException e)
    	{
    		System.out.println(e);
    		return e.toString();
		}
    }
}
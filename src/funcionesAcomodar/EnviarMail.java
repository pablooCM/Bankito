package funcionesAcomodar;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.eventixLauraCarvajalDianaZuniga.bl.Evento;
import org.eventixLauraCarvajalDianaZuniga.bl.Usuario;

/**
 * 
 * @author danyc
 *
 */
public class EnviarMail
{
	// Propiedades de la conexión
	private Properties props = new Properties();
	
	
	public EnviarMail()
	{
		this.props.setProperty("mail.smtp.host", "smtp.gmail.com");
		this.props.setProperty("mail.smtp.starttls.enable", "true");
		this.props.setProperty("mail.smtp.port", "587");
		this.props.setProperty("mail.smtp.user", "eventix.laurac.dianaz@gmail.com");
		this.props.setProperty("mail.smtp.auth", "true");
	}
	
    public boolean EnviarMailRegistro(Usuario responsable, Usuario participante, Evento evento)
    {
    	// Preparamos la sesion
    	Session session = Session.getDefaultInstance(props);
    	
    	// Construimos el mensaje
    	MimeMessage message = new MimeMessage(session);
    	try
    	{
	    	message.setFrom(new InternetAddress("eventix.laurac.dianaz@gmail.com"));
	    	message.addRecipient(
	    			Message.RecipientType.TO,
	    			new InternetAddress(responsable.getCorreoElectronico()));
	    	message.addRecipient(
	    			Message.RecipientType.TO,
	    			new InternetAddress(participante.getCorreoElectronico()));
	    	
	    	message.setSubject("Comprobación de inscripción al evento: "+evento.getIdEvento()+":"+evento.getNombre());
	    	message.setText("El usuario "+participante.getNombreCompleto()+", cédula "+participante.getIdentificacion()+", acaba de realizar su inscripción al evento: "+evento.toString());
	    	// Lo enviamos.
	    	Transport t = session.getTransport("smtp");
	    	t.connect("eventix.laurac.dianaz@gmail.com", "1234eventix");
	    	t.sendMessage(message, message.getAllRecipients());
	    	// Cierre.
	    	t.close();
	    	return true;
    	}
    	catch( MessagingException e)
    	{
			e.printStackTrace();
    		return false;
		}
    }
    
    public boolean EnviarMailDesregistro(Usuario responsable, Usuario participante, Evento evento)
    {
    	// Preparamos la sesion
    	Session session = Session.getDefaultInstance(props);
    	
    	// Construimos el mensaje
    	MimeMessage message = new MimeMessage(session);
    	try
    	{
	    	message.setFrom(new InternetAddress("eventix.laurac.dianaz@gmail.com"));
	    	message.addRecipient(
	    			Message.RecipientType.TO,
	    			new InternetAddress(responsable.getCorreoElectronico()));
	    	message.addRecipient(
	    			Message.RecipientType.TO,
	    			new InternetAddress(participante.getCorreoElectronico()));
	    	
	    	message.setSubject("Comprobación de des-inscripción al evento: "+evento.getIdEvento()+":"+evento.getNombre());
	    	message.setText("El usuario "+participante.getNombreCompleto()+", cédula "+participante.getIdentificacion()+", acaba de darse de baja en la participación del evento: "+evento.toString());
	    	// Lo enviamos.
	    	Transport t = session.getTransport("smtp");
	    	t.connect("eventix.laurac.dianaz@gmail.com", "1234eventix");
	    	t.sendMessage(message, message.getAllRecipients());
	    	// Cierre.
	    	t.close();
	    	return true;
    	}
    	catch( MessagingException e)
    	{
			e.printStackTrace();
    		return false;
		}
    }
}
package digital.places.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
 
@Component("mailService")
public class AppMailer 
{          
    @Autowired
    private MailSender mailSender;
     
    @Autowired
    private SimpleMailMessage preConfiguredMessage;
 
    private static final String defaultTo = "rmadhuri2015@gmail.com";
    
    /**
     * This method will send compose and send the message 
     * */
    public void sendMail(String to, final String subject, final String body) 
    {
        SimpleMailMessage message = new SimpleMailMessage();
        if (to == null)
        {
        	to = defaultTo;
        }
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
 
    /**
     * This method will send a pre-configured message
     * */
    public void sendPreConfiguredMail(final String message) 
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
}
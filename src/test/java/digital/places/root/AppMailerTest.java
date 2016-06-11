package digital.places.root;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppMailerTest 
{
	@Mock
	private MailSender mailSender;

	@Mock
	private SimpleMailMessage preConfiguredMessage;

	@InjectMocks
	private AppMailer appMailer;

	@BeforeMethod
	public void mockSend()
	{
		MockitoAnnotations.initMocks(this);
		Mockito.doNothing().when(mailSender).send(preConfiguredMessage);
	}
	
	@Test
	public void sendMailTest()
	{
		appMailer.sendMail("rmadhrui2014@gas.com", "Test", "Testtest");	
	}

	@Test
	public void sendPreConfiguredMailTest()
	{
		appMailer.sendPreConfiguredMail("PreTesttest");	
	}
}

package digital.places.root;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest 
{
	@Test
	public void testTitle()
	{
		WebDriver wdriver = new HtmlUnitDriver(true);
		wdriver.get("http://localhost:8080/auth");
		String title = wdriver.getTitle();
		Assert.assertEquals(title, "Auth - Login Page");
		
	}
}

package digital.places.root;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest
{
	private final WebDriver wdriver = new HtmlUnitDriver(true);

	private final String uri = "http://localhost:8080/auth";
	
	public ResponseEntity<String> testStatusCode(final String uri)
	{
		RestTemplate restTemplate = new RestTemplate(); 
		return restTemplate.getForEntity(uri, String.class); 
	}

	public String testTitle(final String uri)
	{
		wdriver.get(uri);
		return wdriver.getTitle();

	}
	
	public String testMetaDescription(final String uri)
	{
		wdriver.get(uri);
		return wdriver.findElement(By.xpath("//meta[@name='description']@content")).getText();
	}

	@Test
	public void testPageLoad()
	{
		String title = testTitle(uri);
		Assert.assertEquals(title, "Auth - Login Page");
		String desc = testMetaDescription(uri);
		ResponseEntity<String> response = testStatusCode(uri);
		Assert.assertEquals(response.getStatusCode(),HttpStatus.NOT_FOUND);
	}
	
}

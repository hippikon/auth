package digital.places.root;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NLITest
{
	private final WebDriver wdriver = new HtmlUnitDriver(true);
	
	List<Page> NLIvalidURLs = new ArrayList<Page>();
	List<Page> NLInotfoundURLs = new ArrayList<Page>();
	
	private static final DataUtils dataUtils = new DataUtils();
	
	@BeforeClass
	public void loadData()
	{
		NLIvalidURLs = dataUtils.loadValidURLs();
		NLInotfoundURLs = dataUtils.loadInvalidURLs();
	}

	private ResponseEntity<String> testStatusCode(final Page page)
	{
		RestTemplate restTemplate = new RestTemplate(); 
		return restTemplate.getForEntity(page.getUrl(), String.class); 
	}

	private boolean testTitle(final Page page)
	{
		return wdriver.getTitle().equals(page.getTitle());

	}
	
	private boolean testMetaDescription(final Page page)
	{
		return wdriver.findElement(By.xpath("//meta[@name='description']")).getAttribute("content").equals(page.getMetaDescription());
	}
	
	@Test
	public void testValidNLIURLs()
	{
		Iterator<Page> i = NLIvalidURLs.iterator();
		
		while (i.hasNext())
		{
			Page page = i.next();
			wdriver.get(page.getUrl());
			Assert.assertTrue(testTitle(page));
			Assert.assertTrue(testMetaDescription(page));
			
			ResponseEntity<String> response = testStatusCode(page);
			Assert.assertEquals(response.getStatusCode(),HttpStatus.OK);
		}
	}

	@Test(expectedExceptions = HttpClientErrorException.class,expectedExceptionsMessageRegExp = "404 Not Found")
	public void testNonExistentNLIURLs()
	{
		Iterator<Page> i = NLInotfoundURLs.iterator();
		
		while (i.hasNext())
		{
			testStatusCode(i.next());
		}
	}
	
}

package digital.places.root;

import java.text.ParseException;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthBaseTest 
{
	@Test (expectedExceptions = ParseException.class)
	public void allNullsTest() throws ParseException 
	{
		AuthBase.parseDate(null, null, null);
	}

	@Test (expectedExceptions = ParseException.class)
	public void dateNullTest() throws ParseException 
	{
		AuthBase.parseDate(null, "5", "1999");
	}

	@Test (expectedExceptions = ParseException.class)
	public void monthNullTest() throws ParseException 
	{
		AuthBase.parseDate("13", null, "1999");
	}

	@Test (expectedExceptions = ParseException.class)
	public void yearNullTest() throws ParseException 
	{
		AuthBase.parseDate("13", "5", null);
	}

	@Test 
	public void validDateTest() throws ParseException 
	{
		Date valid = AuthBase.parseDate("13", "5", "1999");
		Assert.assertNotNull(valid);
	}

	@Test 
	public void validDateTest2() throws ParseException 
	{
		Date valid = AuthBase.parseDate("1", "0", "1915");
		Assert.assertNotNull(valid);
	}

	@Test 
	public void validDateTest3() throws ParseException 
	{
		Date valid = AuthBase.parseDate("31", "11", "1999");
		Assert.assertNotNull(valid);
	}

	@Test (expectedExceptions = ParseException.class)
	public void invalidDateTest() throws ParseException 
	{
		AuthBase.parseDate("13", "25", "1999");
	}

	@Test (expectedExceptions = ParseException.class)
	public void invalidDateTestApr() throws ParseException 
	{
		AuthBase.parseDate("31", "3", "1999");
	}

	@Test (expectedExceptions = ParseException.class)
	public void invalidDateTestJun() throws ParseException 
	{
		AuthBase.parseDate("31", "5", "1999");
	}

	@Test (expectedExceptions = ParseException.class)
	public void invalidDateTestSep() throws ParseException 
	{
		AuthBase.parseDate("31", "8", "1999");
	}

	@Test (expectedExceptions = ParseException.class)
	public void invalidDateTestNov() throws ParseException 
	{
		AuthBase.parseDate("31", "10", "1999");
	}

	@Test (expectedExceptions = ParseException.class)
	public void invalidDateTestFeb() throws ParseException 
	{
		AuthBase.parseDate("30", "1", "1999");
	}

	@Test (expectedExceptions = ParseException.class)
	public void invalidDateTestFeb2() throws ParseException 
	{
		AuthBase.parseDate("29", "1", "1999");
	}

	@Test 
	public void validDateTestFeb3() throws ParseException 
	{
		Date valid = AuthBase.parseDate("29", "1", "2000");
		Assert.assertNotNull(valid);
	}
}


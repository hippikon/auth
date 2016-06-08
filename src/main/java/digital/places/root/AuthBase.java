package digital.places.root;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

public class AuthBase 
{
	
    public static Date parseDate(final String day, final String month, final String year) throws ParseException
    {
		Date outputDate = null;
		if (!StringUtils.isEmpty(day) && !StringUtils.isEmpty(month) &&!StringUtils.isEmpty(year))
		{
		    Calendar c = Calendar.getInstance();

		    int iMonth = Integer.parseInt(month);
		    if (iMonth < 0 || iMonth > 11)
		    {
		    	throw new ParseException("invalid month",iMonth);
		    }
		    
		    int iDay = Integer.parseInt(day);
		    if (iDay < 1 || iDay > 31)
		    {
		    	throw new ParseException("invalid day",iDay);
		    }
		    
		    if ((iMonth == 3 || iMonth == 5 || iMonth == 8 || iMonth == 10) && (iDay > 30))
		    {
		    	throw new ParseException("invalid day",iDay);
		    }

		    if ((iMonth == 1) && (iDay > 29))
		    {
		    	throw new ParseException("invalid day",iDay);
		    }

		    int iYear = Integer.parseInt(year);
		    if ((iMonth == 1) && (iYear % 4 > 0) && (iDay > 28))
		    {
		    	throw new ParseException("invalid day",iDay);
		    }

		    c.set(iYear, iMonth, iDay);
		    outputDate = new Date(c.getTimeInMillis());
		}
		else
		{
			throw new ParseException("invalid date",0);
		}
		return outputDate;
    }

}

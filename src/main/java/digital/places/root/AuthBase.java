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
		    c.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		    outputDate = new Date(c.getTimeInMillis());
		}
		else
		{
			throw new ParseException("invalid date",0);
		}
		return outputDate;
    }

}

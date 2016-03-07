package digital.places.root;

import java.sql.Date;
import java.util.Calendar;

import javax.sql.DataSource;

import org.springframework.util.StringUtils;

public class AppUtils
{
    public static DataSource dataSource;

    public void setDataSource(DataSource dataSource)
    {
	if (AppUtils.dataSource == null)
	{
	    AppUtils.dataSource = dataSource;
	}
    }
    
    public static Date parseDate(String day, String month, String year, String format)
    {
	Date outputDate = null;
	if (!StringUtils.isEmpty(day) && !StringUtils.isEmpty(month) &&!StringUtils.isEmpty(year) && !StringUtils.isEmpty(format))
	{
	    Calendar c = Calendar.getInstance();
	    c.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
	    outputDate = new Date(c.getTimeInMillis());
	}
	return outputDate;
    }
    
}

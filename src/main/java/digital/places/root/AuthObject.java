package digital.places.root;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AuthObject
{
	public static final LinkedHashMap<String, String> UYYYY = new LinkedHashMap<String, String>();
	private final ObjectMapper objectMapper = new ObjectMapper();
	static
	{
		UYYYY.put("", "YYYY");
		UYYYY.put(String.valueOf(2015), String.valueOf(2015));
		UYYYY.put(String.valueOf(2016), String.valueOf(2016));
	}

	public static final LinkedHashMap<String, String> UDD = new LinkedHashMap<String, String>();

	static
	{
		UDD.put("", "DD");
		UDD.put(String.valueOf(1), String.valueOf(1));
		UDD.put(String.valueOf(2), String.valueOf(2));
		UDD.put(String.valueOf(3), String.valueOf(3));
		UDD.put(String.valueOf(4), String.valueOf(4));
		UDD.put(String.valueOf(5), String.valueOf(5));
		UDD.put(String.valueOf(6), String.valueOf(6));
		UDD.put(String.valueOf(7), String.valueOf(7));
		UDD.put(String.valueOf(8), String.valueOf(8));
		UDD.put(String.valueOf(9), String.valueOf(9));
		UDD.put(String.valueOf(10), String.valueOf(10));
		UDD.put(String.valueOf(11), String.valueOf(11));
		UDD.put(String.valueOf(12), String.valueOf(12));
		UDD.put(String.valueOf(13), String.valueOf(13));
		UDD.put(String.valueOf(14), String.valueOf(14));
		UDD.put(String.valueOf(15), String.valueOf(15));
		UDD.put(String.valueOf(16), String.valueOf(16));
		UDD.put(String.valueOf(17), String.valueOf(17));
		UDD.put(String.valueOf(18), String.valueOf(18));
		UDD.put(String.valueOf(19), String.valueOf(19));
		UDD.put(String.valueOf(20), String.valueOf(20));
		UDD.put(String.valueOf(21), String.valueOf(21));
		UDD.put(String.valueOf(22), String.valueOf(22));
		UDD.put(String.valueOf(23), String.valueOf(23));
		UDD.put(String.valueOf(24), String.valueOf(24));
		UDD.put(String.valueOf(25), String.valueOf(25));
		UDD.put(String.valueOf(26), String.valueOf(26));
		UDD.put(String.valueOf(27), String.valueOf(27));
		UDD.put(String.valueOf(28), String.valueOf(28));
		UDD.put(String.valueOf(29), String.valueOf(29));
		UDD.put(String.valueOf(30), String.valueOf(30));
		UDD.put(String.valueOf(31), String.valueOf(31));
	}

	public static final LinkedHashMap<String, String> UMM = new LinkedHashMap<String, String>();

	static
	{
		UMM.put("", "MMM");
		UMM.put(String.valueOf(0), "JAN");
		UMM.put(String.valueOf(1), "FEB");
		UMM.put(String.valueOf(2), "MAR");
		UMM.put(String.valueOf(3), "APR");
		UMM.put(String.valueOf(4), "MAY");
		UMM.put(String.valueOf(5), "JUN");
		UMM.put(String.valueOf(6), "JUL");
		UMM.put(String.valueOf(7), "AUG");
		UMM.put(String.valueOf(8), "SEP");
		UMM.put(String.valueOf(9), "OCT");
		UMM.put(String.valueOf(10), "NOV");
		UMM.put(String.valueOf(11), "DEC");
	}

	public static final LinkedHashMap<String, String> UDOBY = new LinkedHashMap<String, String>();

	static
	{
		UDOBY.put("", "YYYY");
		for (int i = 1915; i < 1999; i++)
		{
			UDOBY.put(String.valueOf(i), String.valueOf(i));

		}
	}

	@Override
	public String toString()
	{
		String output = "";
		try
		{
			output = objectMapper.writeValueAsString(this);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return output;
	}

}

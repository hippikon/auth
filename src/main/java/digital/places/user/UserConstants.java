package digital.places.user;

import java.util.LinkedHashMap;

public class UserConstants
{
    static final String ADDPAGE = "add";
    static final String ADDPAGEURL = "/add";

    static final String VIEWALLPAGE = "viewall";
    static final String VIEWALLPAGEURL = "/viewall";
    
    public static final LinkedHashMap<String,String> UDD = new LinkedHashMap<String,String>();

    static
    {
		UDD.put("","");
		UDD.put(String.valueOf(1),String.valueOf(1));
		UDD.put(String.valueOf(2),String.valueOf(2));
		UDD.put(String.valueOf(3),String.valueOf(3));
		UDD.put(String.valueOf(4),String.valueOf(4));
		UDD.put(String.valueOf(5),String.valueOf(5));
		UDD.put(String.valueOf(6),String.valueOf(6));
		UDD.put(String.valueOf(7),String.valueOf(7));
		UDD.put(String.valueOf(8),String.valueOf(8));
		UDD.put(String.valueOf(9),String.valueOf(9));
		UDD.put(String.valueOf(10),String.valueOf(10));
		UDD.put(String.valueOf(11),String.valueOf(11));
		UDD.put(String.valueOf(12),String.valueOf(12));
		UDD.put(String.valueOf(13),String.valueOf(13));
		UDD.put(String.valueOf(14),String.valueOf(14));
		UDD.put(String.valueOf(15),String.valueOf(15));
		UDD.put(String.valueOf(16),String.valueOf(16));
		UDD.put(String.valueOf(17),String.valueOf(17));
		UDD.put(String.valueOf(18),String.valueOf(18));
		UDD.put(String.valueOf(19),String.valueOf(19));
		UDD.put(String.valueOf(20),String.valueOf(20));
		UDD.put(String.valueOf(21),String.valueOf(21));
		UDD.put(String.valueOf(22),String.valueOf(22));
		UDD.put(String.valueOf(23),String.valueOf(23));
		UDD.put(String.valueOf(24),String.valueOf(24));
		UDD.put(String.valueOf(25),String.valueOf(25));
		UDD.put(String.valueOf(26),String.valueOf(26));
		UDD.put(String.valueOf(27),String.valueOf(27));
		UDD.put(String.valueOf(28),String.valueOf(28));
		UDD.put(String.valueOf(29),String.valueOf(29));
		UDD.put(String.valueOf(30),String.valueOf(30));
		UDD.put(String.valueOf(31),String.valueOf(31));
    }


    public static final LinkedHashMap<String,String> UMM = new LinkedHashMap<String,String>();
    
    static
    {
		UMM.put("","");
		UMM.put(String.valueOf(1),String.valueOf(1));
		UMM.put(String.valueOf(2),String.valueOf(2));
		UMM.put(String.valueOf(3),String.valueOf(3));
		UMM.put(String.valueOf(4),String.valueOf(4));
		UMM.put(String.valueOf(5),String.valueOf(5));
		UMM.put(String.valueOf(6),String.valueOf(6));
		UMM.put(String.valueOf(7),String.valueOf(7));
		UMM.put(String.valueOf(8),String.valueOf(8));
		UMM.put(String.valueOf(9),String.valueOf(9));
		UMM.put(String.valueOf(10),String.valueOf(10));
		UMM.put(String.valueOf(11),String.valueOf(11));
		UMM.put(String.valueOf(12),String.valueOf(12));
    }


    public static final LinkedHashMap<String,String> UDOBY = new LinkedHashMap<String,String>();
    
    static
    {
		UDOBY.put("","");
		for (int i=1915; i <1999; i++)
		{
			UDOBY.put(String.valueOf(i),String.valueOf(i));
			
		}
    }

    public static final LinkedHashMap<String,String> UYYYY = new LinkedHashMap<String,String>();
    
    static
    {
    	UYYYY.put("","");
    	UYYYY.put(String.valueOf(2015),String.valueOf(2015));
    	UYYYY.put(String.valueOf(2016),String.valueOf(2016));
    }
}

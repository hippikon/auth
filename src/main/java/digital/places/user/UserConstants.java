package digital.places.user;

import java.util.LinkedHashMap;

class UserConstants
{
    static final String ADDPAGE = "add";
    static final String ADDPAGEURL = "/add";

    static final String UPDATEPAGE = "update";
    static final String UPDATEPAGEURL = "/update";

    static final String VIEWALLPAGE = "viewall";
    static final String VIEWALLPAGEURL = "/viewall";
    
    static final String ADDCONFIRMPAGE = "addconfirm";


    public static final LinkedHashMap<String,String> UDOBY = new LinkedHashMap<String,String>();
    
    static
    {
		UDOBY.put("","YYYY");
		for (int i=1915; i <1999; i++)
		{
			UDOBY.put(String.valueOf(i),String.valueOf(i));
			
		}
    }

}

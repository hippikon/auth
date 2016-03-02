package digital.places.userrole;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Its a servlet
@Controller
public class UserRoleRestService
{
    private static Integer userNum = new Integer(0);
    private static Map<Integer, UserRole> roleMap;

    @RequestMapping(value = UserRoleConstants.ADDPAGEURL, method = RequestMethod.POST)
    public String associateUsersWithRole(@ModelAttribute("username") String userName)
    {
	if (StringUtils.isEmpty(userName))
	{
	    return "redirect:/user/search";
	}
	return "redirect:"+UserRoleConstants.ADDPAGEURL;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder)
    {
	dataBinder.setRequiredFields(new String[] { "rolename","expiry"});
	dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
    }


}

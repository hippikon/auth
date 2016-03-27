package digital.places.userrole;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import digital.places.role.Role;
import digital.places.root.AppContextJavaProvider;

// Its a servlet
@Controller
public class UserRoleRestService
{
    private static Integer userNum = new Integer(0);
    private static Map<Integer, Role> roleMap;

    @RequestMapping(value = UserRoleConstants.ADDPAGEURL, method = RequestMethod.GET)
    public String viewaddpage(@PathVariable String uname, Model model)
    {
		if (StringUtils.isEmpty(uname))
		{
		    return "redirect:/user/search";
		}

		UserRole userrole = new UserRole();
		userrole.setUsername(uname);
		userrole.setAllroles(userrole.findAllPotential(uname));
		model.addAttribute("userrole", userrole);

		return UserRoleConstants.ADDPAGE;
    }

    @RequestMapping(value = UserRoleConstants.DEFAULTADDPAGEURL, method = RequestMethod.GET)
    public String redirectToSearch()
    {
	    Role role = (Role) AppContextJavaProvider.getApplicationContext().getBean("roleProxy");
	    role.findAll();
    	return "redirect:/user/search";
    }

    @RequestMapping(value = UserRoleConstants.ADDPAGEURL, method = RequestMethod.POST)
    public String associateUsersWithRoles(@ModelAttribute("userrole") UserRole userrole, Model model)
    {
    	for (UserRole role:userrole.getAllroles())
    	{
    		try 
    		{
				role.add();
			} 
    		catch (Exception e) 
    		{
				return UserRoleConstants.ADDPAGE;
			}
    	}
    	
		return "addconfirm";
    }

    
    @InitBinder
    public void initBinder(WebDataBinder dataBinder)
    {
//    	dataBinder.setRequiredFields(new String[] { "selectedRoles"});
        dataBinder.registerCustomEditor(Date.class, 
                new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), true));
    }


}

package digital.places.role;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// Its a servlet
@Controller
public class RoleRestService
{
    private static Integer userNum = new Integer(0);
    private static Map<Integer, Role> roleMap;

    @RequestMapping(value = RoleConstants.ADDPAGEURL, method = RequestMethod.GET)
    public String viewaddpage(@RequestParam("username") String username, Model model)
    {
		if (StringUtils.isEmpty(username))
		{
		    return "redirect:/user/search";
		}

//		Role role = new Role();
//    	List<Role> allRoles = role.findAll();
//    	List<Role> userroles = role.findAll(username);
//    	for (Role r:allRoles)
//    	{
//    		if (userroles.contains(r))
//    		{
//    			r.setSelected("checked");
//    			r.setUpsertid(0);
//    			r.setUsername(username);
//    		}
//    	}
		UserRole userrole = new UserRole();
		userrole.setUsername(username);
		userrole.setAllroles(userrole.findAllPotential(username));
		model.addAttribute("userrole", userrole);
//		
//    	model.addAttribute("userroles",userRole.findAllRoleNames(username));

		return RoleConstants.ADDPAGE;
    }


    @RequestMapping(value = RoleConstants.ADDPAGEURL, method = RequestMethod.POST)
    public String associateUsersWithRole(@ModelAttribute("userrole") UserRole userrole, Model model)
    {
		return "addconfirm";
    }

//    @InitBinder
//    public void initBinder(WebDataBinder dataBinder)
//    {
//    	dataBinder.setRequiredFields(new String[] { "selectedRoles"});
////	dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
//    }


}

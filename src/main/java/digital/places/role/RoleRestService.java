package digital.places.role;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// Its a servlet
@Controller
public class RoleRestService
{
    private static Integer userNum = new Integer(0);
    private static Map<Integer, Role> roleMap;

    @RequestMapping(value = RoleConstants.ADDPAGEURL, method = RequestMethod.POST)
    public String associateUsersWithRole(@RequestParam("user") String user, Model model)
    {
		if (StringUtils.isEmpty(user))
		{
		    return "redirect:/user/search";
		}
		Role role = new Role();
    	model.addAttribute("roles",role.findAllRoleNames());

		UserRole urole = new UserRole();
		model.addAttribute("userrole",urole);
    	model.addAttribute("userroles",urole.findAllRoleNames(user));
    	
		return RoleConstants.ADDPAGE;
    }

//    @InitBinder
//    public void initBinder(WebDataBinder dataBinder)
//    {
//	dataBinder.setRequiredFields(new String[] { "rolename","expiry"});
//	dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
//    }


}

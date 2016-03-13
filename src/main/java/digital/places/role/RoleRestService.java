package digital.places.role;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

		UserRole userRole = new UserRole();
		userRole.setUsername(username);
		model.addAttribute("userrole", userRole);
    	model.addAttribute("userroles",userRole.findAllRoleNames(username));

		Role role = new Role();
    	model.addAttribute("roles",role.findAllRoleNames());

		return RoleConstants.ADDPAGE;
    }


    @RequestMapping(value = RoleConstants.ADDPAGEURL, method = RequestMethod.POST)
    public String associateUsersWithRole(@ModelAttribute("userrole") UserRole userRole, BindingResult result, Model model)
    {
		if (result.hasErrors())
		{
		    return RoleConstants.ADDPAGE;
		}

		return "addconfirm";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder)
    {
    	dataBinder.setRequiredFields(new String[] { "selectedRoles"});
//	dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
    }


}

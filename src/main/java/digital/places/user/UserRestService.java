package digital.places.user;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
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

import digital.places.root.AppConstants;

// Its a servlet
@Controller
public class UserRestService
{
    @RequestMapping(value = UserConstants.ADDPAGEURL, method = RequestMethod.GET)
    public String viewaddpage(Model model)
    {
		User user = new User();
		model.addAttribute("user", user);
		return UserConstants.ADDPAGE;
    }

    @RequestMapping(value = UserConstants.ADDPAGEURL, method = RequestMethod.POST)
    public String create(@ModelAttribute("user") User user, BindingResult result, Model model)
    {
		if (result.hasErrors())
		{
		    return UserConstants.ADDPAGE;
		}
	
		try
		{
		    user.addToDatastore();
		    model.addAttribute("uname",user.getUsername());
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		    model.addAttribute("error","Unexpected error occured");
		    return UserConstants.ADDPAGE;
		}
		return UserConstants.CONFIRMPAGE;
    }

    @RequestMapping(value = AppConstants.SEARCHPAGEURL, method = RequestMethod.GET)
    public String load() throws SQLException, ParseException
    {
    	return AppConstants.SEARCHPAGE;
    }
    
    @RequestMapping(value = AppConstants.SEARCHPAGEURL, method = RequestMethod.POST)
    public String search(@RequestParam(value = "usearch") String usearch, Model model) throws SQLException, ParseException
    {
    	User user = new User();
    	List<User> searchResults = user.findAllByUsername(usearch);
    	model.addAttribute("searchUser",searchResults);
    	return AppConstants.SEARCHPAGE;
    }

    @RequestMapping(value = UserConstants.UPDATEPAGEURL, method = RequestMethod.GET)
    public String viewupdatepage(@RequestParam("uname") String uname, Model model)
    {
		if (StringUtils.isEmpty(uname))
		{
		    return "redirect:/user/search";
		}

		User user = new User().identify(uname).findInDatastore().prepUpdate();
		model.addAttribute("user", user);
		return UserConstants.UPDATEPAGE;
    }
    
    @RequestMapping(value = UserConstants.UPDATEPAGEURL, method = RequestMethod.POST)
    public String update(@ModelAttribute("user") User user, BindingResult result, Model model)
    {
		if (result.hasErrors())
		{
		    return UserConstants.UPDATEPAGE;
		}
	
		try
		{
		    user.update();
		    model.addAttribute("username",user.getUsername());
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		    model.addAttribute("error","Unexpected error occured");
		    return UserConstants.ADDPAGE;
		}
		return UserConstants.CONFIRMPAGE;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder)
    {
		dataBinder.setRequiredFields(new String[] { "username","ufname", "ulname", "udobdd","udobmm", "udobyyyy","ustartdatedd","ustartdatemm","ustartdateyyyy","enabled", "uemail", "password", "ulocation"});
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
    }
}

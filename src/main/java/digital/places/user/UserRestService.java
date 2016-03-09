package digital.places.user;

import java.sql.SQLException;
import java.text.ParseException;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String create(@ModelAttribute("user") User user, BindingResult result)
    {
	if (result.hasErrors())
	{
	    return UserConstants.ADDPAGE;
	}

	try
	{
	    user.addToDatastore();
	}
	catch (Exception e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return "redirect:"+UserConstants.VIEWALLPAGE;
    }

    @RequestMapping(value = AppConstants.SEARCHPAGEURL, method = RequestMethod.GET)
    public String load(Model model) throws SQLException, ParseException
    {
	SearchUser searchUser = new SearchUser("");
	model.addAttribute("searchUser",searchUser);
	return AppConstants.SEARCHPAGE;
    }
    
    @RequestMapping(value = AppConstants.SEARCHPAGEURL, method = RequestMethod.POST)
    public String search(@RequestParam(value = "searchString") String searchString, Model model) throws SQLException, ParseException
    {
	SearchUser searchUser = new SearchUser(searchString);
	model.addAttribute("searchUser",searchUser);
	return AppConstants.SEARCHPAGE;
    }

    @RequestMapping(value = UserConstants.VIEWALLPAGEURL, method = RequestMethod.GET)
    public String viewall(Model model)
    {
	return UserConstants.VIEWALLPAGE;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder)
    {
	dataBinder.setRequiredFields(new String[] { "username","ufname", "ulname", "udobdd", "ustartdatedd","enabled", "uemail", "password", "ulocation"});
	dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
    }
}

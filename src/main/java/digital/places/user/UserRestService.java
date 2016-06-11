package digital.places.user;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import digital.places.root.Links;

// Its a servlet
@Controller
public class UserRestService implements Links
{
	private UserFacade userDAO;

	@RequestMapping(value = ADDPAGEURL, method = RequestMethod.GET)
	public String viewaddpage(Model model)
	{
		User user = new User();
		model.addAttribute("user", user);
		return ADDPAGE;
	}

	@RequestMapping(value = ADDPAGEURL, method = RequestMethod.POST)
	public String create(@ModelAttribute("user") User user, BindingResult result, Model model)
	{
		if (result.hasErrors())
		{
			return ADDPAGE;
		}

		try
		{
			System.out.println(user);
			userDAO.add(user);
			model.addAttribute("uname", user.getUsername());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			model.addAttribute("error", "Unexpected error occured");
			return ADDPAGE;
		}
		return CONFIRMPAGE;
	}

	@RequestMapping(value = SEARCHPAGEURL, method = RequestMethod.GET)
	public String load() throws SQLException, ParseException
	{
		return SEARCHPAGE;
	}

	@RequestMapping(value = SEARCHPAGEURL, method = RequestMethod.POST)
	public String search(@RequestParam(value = "usearch") String usearch, Model model)
			throws SQLException, ParseException
	{
		List<User> searchResults = userDAO.findAllByUsername(usearch);
		model.addAttribute("searchUser", searchResults);
		return SEARCHPAGE;
	}

	@RequestMapping(value = UPDATEPAGEURL, method = RequestMethod.GET)
	public String viewupdatepage(@RequestParam("uname") String uname, Model model)
	{
		if (StringUtils.isEmpty(uname))
		{
			return "redirect:/user/search";
		}

		User user = userDAO.findByUsername(uname);
		model.addAttribute("user", user);
		return UPDATEPAGE;
	}

	@RequestMapping(value = UPDATEPAGEURL, method = RequestMethod.POST)
	public String update(@ModelAttribute("user") User user, BindingResult result, Model model)
	{
		if (result.hasErrors())
		{
			return UPDATEPAGE;
		}

		try
		{
			userDAO.update(user);
			model.addAttribute("uname", user.getUsername());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			model.addAttribute("error", "Unexpected error occured");
			return ADDPAGE;
		}
		return CONFIRMPAGE;
	}

	@Autowired
	public void setUserDAO(UserFacade userDAO)
	{
		this.userDAO = userDAO;
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder)
	{
		dataBinder.setRequiredFields(new String[] { "username", "ufname", "ulname", "udobdd", "udobmm", "udobyyyy",
				"ustartdatedd", "ustartdatemm", "ustartdateyyyy", "enabled", "uemail", "password", "ulocation" });
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}
}

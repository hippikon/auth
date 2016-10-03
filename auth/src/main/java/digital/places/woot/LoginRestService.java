package digital.places.woot;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import digital.places.root.Links;

// Its a servlet
@Controller
public class LoginRestService implements Links
{
	@RequestMapping(value = LOGINPAGEURL, method = RequestMethod.GET)
	public ModelAndView login1(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout)
	{
		ModelAndView model = new ModelAndView();
		if (error != null)
		{
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null)
		{
			model.addObject("msg", "You've been logged out successfully.");
		}

		model.setViewName(LOGINPAGE);

		return model;
	}

	// for 403 access denied page
	@RequestMapping(value = PAGE403URL, method = RequestMethod.GET)
	public ModelAndView accesssDenied()
	{

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken))
		{
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		}

		model.setViewName(PAGE403);
		return model;

	}

	// for 404 
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String notFound()
	{
		return "404";
	}
}

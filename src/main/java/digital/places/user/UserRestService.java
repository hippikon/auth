package digital.places.user;

import java.sql.SQLException;
import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import digital.places.util.AppConstants;

// Its a servlet
@Controller
@Repository
@Transactional
public class UserRestService
{
    @PersistenceContext
    private EntityManager entityManager;

    public User findThisOne(String username) {
        return entityManager.find(User.class, username);
    }

//    @SuppressWarnings("unchecked")
//    public List<User> findAllUsers() {
//        return entityManager.createQuery("from " + User.class.getName()).getResultList();
//    }
//
    public void createMe(User user) {
        entityManager.persist(user);
    }

//    public User updateMe() {
//        return entityManager.merge(User.class);
//    }
//
//    public void deleteMe() {
//	entityManager.remove(this);
//    }
    
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
	    user.addUser();
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

    @RequestMapping(value = AppConstants.LOGINPAGEURL, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
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
        
        model.setViewName(AppConstants.LOGINPAGE);
    
        return model;
    }
	
    //for 403 access denied page
    @RequestMapping(value = AppConstants.PAGE403URL, method = RequestMethod.GET)
    public ModelAndView accesssDenied() 
    {
    
        ModelAndView model = new ModelAndView();
    		
        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) 
        {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();	
            model.addObject("username", userDetail.getUsername());
        }
    		
        model.setViewName(AppConstants.PAGE403);
        return model;
    
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

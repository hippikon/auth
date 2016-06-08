package digital.places.userrole;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.util.StringUtils;

import digital.places.role.Role;
import digital.places.role.RoleFacade;
import digital.places.root.AppContextJavaProvider;
import digital.places.root.AuthBase;
import digital.places.root.DataService;

class UserRoleDAO extends AuthBase implements UserRoleFacade
{
	public List<UserRole> findAllPotential(String user) 
	{
		RoleFacade roleDAO = (RoleFacade) AppContextJavaProvider.getApplicationContext().getBean("roleFacade");
		List<Role> allRoles = roleDAO.fetchAllRoles();
		List<UserRole> allCurUserRoles = findAll(user);
		List<UserRole> allPUserRoles = new ArrayList<UserRole>();

		for (Role role:allRoles)
		{
			UserRole urole = new UserRole();
			urole.setRoleid(role.getRoleid());
			urole.setRoleName(role.getRole());
			urole.setUsername(user);
			if (allCurUserRoles.contains(urole))
			{
				UserRole temp = allCurUserRoles.get(allCurUserRoles.indexOf(urole));
				temp.setSelected("checked");
				temp.setUpsertid(0);
				temp.setRoleName(role.getRole());
			}
			else
			{
				allPUserRoles.add(urole);
			}
		}
		allCurUserRoles.addAll(allPUserRoles);
		return allCurUserRoles;
	}

	public List<UserRole> findAll(String user) 
	{
		DataService dataService = getDataService();
		return (List<UserRole>) dataService.query("select ur from UserRole ur, Role r where r.enabled=1 and ur.enabled=1 and ur.roleid = r.roleid and ur.username = '"+StringUtils.trimAllWhitespace(user)+"'");
	}
	
    private DataService getDataService()
    {
		return (DataService) AppContextJavaProvider.getApplicationContext().getBean("dataService");
    }
    
    public int add(UserRole userRole) throws Exception
    {
		DataService dataService = getDataService();
    	if ("on".equals(userRole.getStrenabled()))
    	{
    		userRole.setEnabled(1);
    	}
    	else
    	{
    		userRole.setEnabled(0);
    	}

    	if (userRole.getUpsertid() == -1 && "on".equals(userRole.getSelected()))
    	{
			//For add page - readonly view of existing records in case of errors
    		userRole.setSelected("");
    		
        	validateUserRole(userRole);
    		dataService.create(userRole);
    		return 1;
    	}
    	else
    	{
    		userRole.setSelected("checked");
			//For add page - readonly view of existing records in case of errors
    		if (userRole.getEnabled() == 0)
    		{
    			userRole.setRoleenddate(Calendar.getInstance().getTime());
    			dataService.update(userRole);
    		}
    	}
    	return 0;
    }
    
    private void validateUserRole(UserRole userRole) throws Exception
    {		
	    try
	    {
	    	userRole.setRolestartdate(parseDate(userRole.getRolesddd(),userRole.getRolesdmm(),userRole.getRolesdyyyy()));
			if (!StringUtils.isEmpty(userRole.getRolesddd()))
			{
				userRole.setRoleenddate(parseDate(userRole.getRolesddd(),userRole.getRolesdmm(),userRole.getRolesdyyyy()));
		    }
		}
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	    	throw e;
	    }
    }
    
}

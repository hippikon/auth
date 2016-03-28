package digital.places.role;

import java.util.List;

public class RoleFacade
{

	public List<Role> fetchAllRoles()
	{
		return Role.allRoles;
	}
	
}

package digital.places.role;

import java.util.List;

import digital.places.root.AuthObject;

public class RoleFacade extends AuthObject implements RoleInterface
{

	public List<Role> fetchAllRoles()
	{
		return Role.allRoles;
	}
	
}

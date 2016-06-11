package digital.places.role;

import java.util.List;

import digital.places.root.AuthObject;

public class RoleDAO implements RoleFacade
{

	public List<Role> fetchAllRoles()
	{
		return Role.allRoles;
	}

}

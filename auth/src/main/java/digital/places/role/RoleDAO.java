package digital.places.role;

import java.util.List;

public class RoleDAO implements RoleFacade
{

	@Override
	public List<Role> fetchAllRoles()
	{
		return Role.allRoles;
	}

}

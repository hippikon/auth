package digital.places.userrole;

import java.util.List;

interface UserRoleFacade
{
	public List<UserRole> findAllPotential(String user);

	public List<UserRole> findAll(String user);

	public int add(UserRole userRole) throws Exception;
}

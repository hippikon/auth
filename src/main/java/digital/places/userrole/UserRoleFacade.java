package digital.places.userrole;

import java.util.List;

interface UserRoleFacade
{
	List<UserRole> findAllPotential(String user);

	List<UserRole> findAll(String user);

	int add(UserRole userRole) throws Exception;
}

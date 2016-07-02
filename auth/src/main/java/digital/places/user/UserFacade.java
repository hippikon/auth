package digital.places.user;

import java.text.ParseException;
import java.util.List;

interface UserFacade
{
	List<User> findAllByUsername(String username);

	User findByUsername(String username);

	void update(User user) throws ParseException;

	void add(User user) throws ParseException;
}

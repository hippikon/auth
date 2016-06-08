package digital.places.user;

import java.text.ParseException;
import java.util.List;

interface UserFacade 
{
	public List<User> findAllByUsername(String username);
	
    public User findByUsername(String username);
    
    public void update(User user) throws ParseException;
    
    public void add(User user) throws ParseException;
}

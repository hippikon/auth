package digital.places.user;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

public class UserDAOTest
{
	User user;
	
	UserDAO userDAO;
	
	@Before
	public void setUp()
	{
		userDAO  = new UserDAO();
		user = new User();
		user.setUdob(new Date("01/01/1979"));
		user.setUstartdate(new Date("01/01/2016"));
		user.setUenddate(null);
//		BDDMockito.when(user.getUdob()).thenReturn(new Date("01/01/1979"));
//		BDDMockito.when(user.getUstartdate()).thenReturn(new Date("01/01/2016"));
//		BDDMockito.when(user.getUenddate()).thenReturn(null);

	}
	
	@Test
	public void prepUpdateTest()
	{
//		Assert.assertEquals(user.getUdobdd(), null);

//		Assert.assertEquals(user.getUdobdd(), null);
		
		userDAO.prepUpdate(user);
		
		Assert.assertEquals("1",user.getUdobdd());
	}
	
}

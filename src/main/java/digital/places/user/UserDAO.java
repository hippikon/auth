package digital.places.user;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import org.springframework.mail.MailSendException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import digital.places.root.AppContextJavaProvider;
import digital.places.root.AppMailer;
import digital.places.root.AuthBase;
import digital.places.root.DataService;

class UserDAO extends AuthBase implements UserFacade
{
	private DataService getDataService()
	{
		return (DataService) AppContextJavaProvider.getApplicationContext().getBean("dataService");
	}

	public List<User> findAllByUsername(String username)
	{
		String sql = "select u from User u where username like '%" + StringUtils.trimAllWhitespace(username) + "%'";
		DataService dataService = getDataService();
		return (List<User>) dataService.query(sql);
	}

	public User findByUsername(String username)
	{
		String sql = "select u from User u where username = '" + StringUtils.trimAllWhitespace(username) + "'";
		DataService dataService = getDataService();
		List<User> users = (List<User>) dataService.query(sql);
		User output = null;
		if (users != null && users.size() > 0)
		{
			output = users.get(0);
			output.setWasEnabled(output.getEnabled());
			prepUpdate(output);
		}
		return output;
	}

	@Transactional (propagation = Propagation.REQUIRED)
	public void update(User user) throws ParseException, MailSendException
	{
		prepStore(user);
		DataService dataService = getDataService();
		dataService.update(user);
		if (user.getWasEnabled() == 1 && user.getEnabled() == 0)
		{
			AppMailer appMailer = (AppMailer) AppContextJavaProvider.getApplicationContext().getBean("mailService");
			appMailer.sendMail(null, "user " + user.getUsername() + " updated", "status disabled");
		}
	}

	public void add(User user) throws ParseException
	{
		prepStore(user);
		DataService dataService = getDataService();
		dataService.create(user);
	}

	private void prepUpdate(User user)
	{
		Calendar cal = Calendar.getInstance();
		if (user.getUdob() != null)
		{
			cal.setTime(user.getUdob());
			user.setUdobdd(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
			user.setUdobmm(String.valueOf(cal.get(Calendar.MONTH)));
			user.setUdobyyyy(String.valueOf(cal.get(Calendar.YEAR)));
		}

		if (user.getUstartdate() != null)
		{
			cal.setTime(user.getUstartdate());
			user.setUstartdatedd(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
			user.setUstartdatemm(String.valueOf(cal.get(Calendar.MONTH)));
			user.setUstartdateyyyy(String.valueOf(cal.get(Calendar.YEAR)));
		}

		if (user.getUenddate() != null)
		{
			cal.setTime(user.getUenddate());
			user.setUenddatedd(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
			user.setUenddatemm(String.valueOf(cal.get(Calendar.MONTH)));
			user.setUenddateyyyy(String.valueOf(cal.get(Calendar.YEAR)));
		}
	}

	private void prepStore(User user) throws ParseException
	{
		user.setUdob(parseDate(user.getUdobdd(), user.getUdobmm(), user.getUdobyyyy()));
		user.setUstartdate(parseDate(user.getUstartdatedd(), user.getUstartdatemm(), user.getUstartdateyyyy()));
		if (!StringUtils.isEmpty(user.getUenddatedd()))
		{
			try
			{
				user.setUenddate(parseDate(user.getUenddatedd(), user.getUenddatemm(), user.getUenddateyyyy()));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}

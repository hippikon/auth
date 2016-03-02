package digital.places.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.util.StringUtils;

import digital.places.util.AppUtils;

public class SearchUser
{
    private final String searchString;

    private final User[] results;

    public SearchUser(String input) throws SQLException, ParseException
    {
	searchString = input;
	
	if (!StringUtils.isEmpty(searchString))
	{    
	    results = searchUser(searchString);
	}
	else
	{
	    results = null;
	}
    }

    public String getSearchString()
    {
	return searchString;
    }

    public User[] getResults()
    {
	return results;
    }

    public synchronized User[] searchUser(String searchString) throws SQLException, ParseException
    {
	List<User> resultList = new ArrayList<User>();
	
	// TODOExternalize
	String sql = "select username from users where username like '%"+StringUtils.trimAllWhitespace(searchString)+"%'";
	Connection conn = null;
	Calendar c = Calendar.getInstance();
	try
	{
	    conn = AppUtils.dataSource.getConnection();
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ResultSet rs = ps.executeQuery();

	    while (rs.next())
	    {
		User user = new User();
		user.setUsername(rs.getString("username"));
		resultList.add(user);
	    }
	    
	    if (resultList.size() > 0)
	    {
		return resultList.toArray(new User[1]);
	    }
	    ps.close();
	}
	finally
	{
	    if (conn != null)
	    {
		conn.close();
	    }
	}
	return null;
    }
    
    

}

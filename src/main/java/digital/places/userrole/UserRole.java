package digital.places.userrole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;

import digital.places.root.AppUtils;

public class UserRole
{
    private String username;

    public synchronized void addUser() throws SQLException, ParseException
    {
	if (this.username != null && !"".equals(this.username))
	{
	    //TODOExternalize
	    String sql = "insert into users (username,ufname,ulname,umname,udob,ustartdate,uenddate,enabled,uemail,password,ulocation) values (?,?,?,?,?,?,?,?,?,?,?)"; 
	    Connection conn = null; 
	    Calendar c = Calendar.getInstance();
	    try 
	    { 
		conn = AppUtils.dataSource.getConnection(); 
		PreparedStatement ps = conn.prepareStatement( sql);
		ps.setString ( 1, this.username);
		ps.executeUpdate(); 
		ps.close();     	    
	    } 
	    finally 	
	    { 
		if (conn != null) 
		{ 
		    conn.close(); 
		} 
	    }
	}
    }


    @Override
    public String toString()
    {
	return this.username;
    }

    
}

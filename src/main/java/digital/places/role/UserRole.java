package digital.places.role;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

import digital.places.root.AppContextJavaProvider;
import digital.places.root.DataService;

@Entity
@Table (name="user_roles")
public class UserRole implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column
    private int userroleid;
    
    @Column (columnDefinition = "VARCHAR",length = 20)
    private String username;
    
    @Column
    private int roleid;

    @Column (columnDefinition = "DATETIME")
    private Date rolestartdate;

    @Column (columnDefinition = "DATETIME")
    private Date roleenddate;
    
    @Column (columnDefinition = "TINYINT")
    private int enabled = 1;

    void addToDatastore() 
    {
		DataService dataService = getDataService();
		dataService.create(this);
    }

	public List<UserRole> findAll(String user) {
		DataService dataService = getDataService();
	    return (List<UserRole>)dataService.query("select R from UserRole R where username like '%"+StringUtils.trimAllWhitespace(user)+"%'");
	}

    
    private DataService getDataService()
    {
		return (DataService) AppContextJavaProvider.getApplicationContext().getBean("dataService");
    }
    
    
	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getUserroleid() {
		return userroleid;
	}

	public void setUserroleid(int userroleid) {
		this.userroleid = userroleid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getRolestartdate() {
		return rolestartdate;
	}

	public void setRolestartdate(Date rolestartdate) {
		this.rolestartdate = rolestartdate;
	}

	public Date getRoleenddate() {
		return roleenddate;
	}

	public void setRoleenddate(Date roleenddate) {
		this.roleenddate = roleenddate;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

}

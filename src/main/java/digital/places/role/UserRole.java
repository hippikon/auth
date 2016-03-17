package digital.places.role;

import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import digital.places.root.AppContextJavaProvider;
import digital.places.root.DataService;

@Entity
@Table (name="user_roles")
@SecondaryTables({
    @SecondaryTable(name="roles", pkJoinColumns={@PrimaryKeyJoinColumn(name = "roleid")})
})
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
    
    @Column (table = "roles")
    private String role;

    @Transient
    private List<Role> srids; 

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
		return (List<UserRole>) dataService.query("select ur.userroleid,ur.username,ur.roleid,r.role,ur.rolestartdate,ur.roleenddate,ur.enabled from UserRole ur, Role r where r.enabled=1 and ur.enabled=1 and ur.username like '%"+StringUtils.trimAllWhitespace(user)+"%'");
	}

	public Map<String,String> findAllRoleNames(String user) {
		List<UserRole> userRoles = findAll(user);
		Map<String,String> userRoleNames = new LinkedHashMap<String,String>();
		if (userRoles != null && userRoles.size() > 0)
		{
			for (UserRole userRole:userRoles)
			{
				userRoleNames.put(String.valueOf(userRole.getRoleid()), userRole.getRole());
			}
		}
	    return userRoleNames;
	}
    
    private DataService getDataService()
    {
		return (DataService) AppContextJavaProvider.getApplicationContext().getBean("dataService");
    }
    
    
    
	UserRole cloneThis() throws CloneNotSupportedException 
	{
		UserRole clone = new UserRole();
		clone.setEnabled(this.getEnabled());
		clone.setRole(this.getRole());
		clone.setRoleenddate(this.getRoleenddate());
		clone.setRoleid(this.getRoleid());
		clone.setRolestartdate(this.getRolestartdate());
		clone.setUsername(this.getUsername());
		clone.setUserroleid(this.getUserroleid());
		return clone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Role> getSrids() {
		return srids;
	}

	public void setSrids(List<Role> srids) {
		this.srids = srids;
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

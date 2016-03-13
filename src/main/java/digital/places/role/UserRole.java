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
    private List<String> selectedRoles; 

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
		Object obj = dataService.query("select ur.userroleid,ur.username,ur.roleid,r.role,ur.rolestartdate,ur.roleenddate,ur.enabled from UserRole ur, Role r where r.enabled=1 and ur.enabled=1 and username like '%"+StringUtils.trimAllWhitespace(user)+"%'");
	    return (List<UserRole>)obj;
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
    
    
	public List<String> getSelectedRoles() {
		return selectedRoles;
	}

	public void setSelectedRoles(List<String> selectedRoles) {
		this.selectedRoles = selectedRoles;
	}

    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoleidd() 
	{
		return String.valueOf(roleid);
	}

	public void setRoleidd(String roleid) 
	{
		if (!StringUtils.isEmpty(roleid))
		{
			this.roleid = Integer.valueOf(roleid);
		}
	}

    @Override
	public String toString() {
		return getRoleidd();
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

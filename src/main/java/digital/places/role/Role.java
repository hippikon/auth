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
@Table (name="roles")
public class Role implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column (columnDefinition = "TINYINT")
    private int roleid;
    
    @Column (columnDefinition = "VARCHAR",length = 55)
    private String role;
    
	@Column (columnDefinition = "TINYINT")
    private int enabled = 1;
	
	@Transient
    private String stren = "1";

	@Transient
	private String selected = "";

    @Transient
	private int upsertid = -1;
    
    @Transient
    private String username;

	@Transient
    private Date rolestartdate;

    @Transient
    private Date roleenddate;
    
    @Transient
    private int enabledForUsername = 1;
    
	@Override
	public String toString() 
	{
		return role;
	}

	@Override
	public boolean equals(Object inRole) 
	{
		if (inRole instanceof Role && roleid == ((Role)inRole).roleid)
		{
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 1;
	}

	public List<Role> findAll() 
	{
		DataService dataService = getDataService();
	    return (List<Role>)dataService.query("select r from Role r");
	}

	public List<Role> findAll(String username) 
	{
		DataService dataService = getDataService();
	    return (List<Role>) dataService.query("select r from UserRole ur, Role r where ur.roleid = r.roleid and r.enabled=1 and ur.username like '%"+StringUtils.trimAllWhitespace(username)+"%'");
	}

	
	public Map<String,String> findAllRoleNames() 
	{
		Map<String,String> roleNames = new LinkedHashMap<String,String>();
		List<Role> roles = findAll();
		for (Role role:roles)
		{
			roleNames.put(String.valueOf(role.getRoleid()), role.getRole());
		}
	    return roleNames;
	}

    void addToDatastore() 
    {
		DataService dataService = getDataService();
		dataService.create(this);
    }

    private DataService getDataService()
    {
		return (DataService) AppContextJavaProvider.getApplicationContext().getBean("dataService");
    }
    
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSelected() {
		return selected;
	}

	public int getUpsertid() {
		return upsertid;
	}

	public void setUpsertid(int upsertid) {
		this.upsertid = upsertid;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

    
	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRole() 
	{
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
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

	public int getEnabledForUsername() {
		return enabledForUsername;
	}

	public void setEnabledForUsername(int enabledForUsername) {
		this.enabledForUsername = enabledForUsername;
	}

	public String getStren() {
		return stren;
	}

	public void setStren(String stren) {
		this.stren = stren;
	}


}

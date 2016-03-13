package digital.places.role;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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

    @Override
	public String toString() {
		return role;
	}

	public List<Role> findAll() {
		DataService dataService = getDataService();
	    return (List<Role>)dataService.query("select r from Role r");
	}

	public Map<String,String> findAllRoleNames() {
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

}

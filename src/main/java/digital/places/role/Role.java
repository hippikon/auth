package digital.places.role;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import digital.places.root.AppContextJavaProvider;
import digital.places.root.AuthObject;
import digital.places.root.DataService;

@Entity
@Table(name = "roles")
public class Role extends AuthObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String DEFAULT_FINDALLVALID_QUERY = "select r from Role r where r.enabled = 1";

	static List<Role> allRoles;

	@Id
	@GeneratedValue
	@Column(columnDefinition = "TINYINT")
	private int roleid;

	@Column(columnDefinition = "VARCHAR", length = 55)
	private String role;

	@Column(columnDefinition = "TINYINT")
	private int enabled = 1;

	static void findAll(DataService dataService)
	{
		if (allRoles == null)
		{
			allRoles = (List<Role>) dataService.query(DEFAULT_FINDALLVALID_QUERY);
		}
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

	public int getRoleid()
	{
		return roleid;
	}

	public void setRoleid(int roleid)
	{
		this.roleid = roleid;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}

	public int getEnabled()
	{
		return enabled;
	}

	public void setEnabled(int enabled)
	{
		this.enabled = enabled;
	}

}

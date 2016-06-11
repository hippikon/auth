package digital.places.userrole;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import digital.places.role.Role;
import digital.places.role.RoleFacade;
import digital.places.root.AppContextJavaProvider;
import digital.places.root.AuthObject;
import digital.places.root.DataService;

@Entity
@Table(name = "user_roles")
public class UserRole extends AuthObject implements Serializable
{
	private static final long serialVersionUID = 1L;
	public static final LinkedHashMap<String, String> UDD = AuthObject.UDD;
	public static final LinkedHashMap<String, String> UMM = AuthObject.UMM;
	public static final LinkedHashMap<String, String> UYYYY = AuthObject.UYYYY;

	@Id
	@GeneratedValue
	@Column
	private int userroleid;

	@Column(columnDefinition = "VARCHAR", length = 20)
	private String username;

	@Column
	private int roleid;

	@Transient
	private String roleName;

	@Transient
	private String selected = "";

	@Transient
	private String strenabled = "";

	@Transient
	private int upsertid = -1;

	@Transient
	private List<UserRole> allroles;

	@Column(columnDefinition = "DATETIME")
	private Date rolestartdate;

	@Transient
	private String rolesddd;

	@Transient
	private String rolesdmm;

	@Transient
	private String rolesdyyyy;

	@Column(columnDefinition = "DATETIME")
	private Date roleenddate;

	@Transient
	private String roleeddd;

	@Transient
	private String roleedmm;

	@Transient
	private String roleedyyyy;

	@Column(columnDefinition = "TINYINT")
	private int enabled = 1;

	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

	public List<UserRole> getAllroles()
	{
		return allroles;
	}

	public void setAllroles(List<UserRole> allroles)
	{
		this.allroles = allroles;
	}

	public int getRoleid()
	{
		return roleid;
	}

	public void setRoleid(int roleid)
	{
		this.roleid = roleid;
	}

	public int getUserroleid()
	{
		return userroleid;
	}

	public void setUserroleid(int userroleid)
	{
		this.userroleid = userroleid;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public Date getRolestartdate()
	{
		return rolestartdate;
	}

	public void setRolestartdate(Date rolestartdate)
	{
		this.rolestartdate = rolestartdate;
	}

	public Date getRoleenddate()
	{
		return roleenddate;
	}

	public void setRoleenddate(Date roleenddate)
	{
		this.roleenddate = roleenddate;
	}

	public int getEnabled()
	{
		return enabled;
	}

	public void setEnabled(int enabled)
	{
		this.enabled = enabled;
	}

	public String getRolesddd()
	{
		return rolesddd;
	}

	public void setRolesddd(String rolesddd)
	{
		this.rolesddd = rolesddd;
	}

	public String getRolesdmm()
	{
		return rolesdmm;
	}

	public void setRolesdmm(String rolesdmm)
	{
		this.rolesdmm = rolesdmm;
	}

	public String getRolesdyyyy()
	{
		return rolesdyyyy;
	}

	public void setRolesdyyyy(String rolesdyyyy)
	{
		this.rolesdyyyy = rolesdyyyy;
	}

	public String getRoleeddd()
	{
		return roleeddd;
	}

	public void setRoleeddd(String roleeddd)
	{
		this.roleeddd = roleeddd;
	}

	public String getRoleedmm()
	{
		return roleedmm;
	}

	public void setRoleedmm(String roleedmm)
	{
		this.roleedmm = roleedmm;
	}

	public String getRoleedyyyy()
	{
		return roleedyyyy;
	}

	public void setRoleedyyyy(String roleedyyyy)
	{
		this.roleedyyyy = roleedyyyy;
	}

	public String getSelected()
	{
		return selected;
	}

	public void setSelected(String selected)
	{
		this.selected = selected;
	}

	public String getStrenabled()
	{
		return strenabled;
	}

	public void setStrenabled(String strenabled)
	{
		this.strenabled = strenabled;
	}

	public int getUpsertid()
	{
		return upsertid;
	}

	public void setUpsertid(int upsertid)
	{
		this.upsertid = upsertid;
	}

	public LinkedHashMap<String, String> getUDD()
	{
		return UDD;
	}

	public LinkedHashMap<String, String> getUMM()
	{
		return UMM;
	}

	public LinkedHashMap<String, String> getUYYYY()
	{
		return UYYYY;
	}

	@Override
	public boolean equals(Object iUserRole)
	{
		if (iUserRole instanceof UserRole)
		{
			UserRole temp = (UserRole) iUserRole;
			if (!StringUtils.isEmpty(this.username) && this.username.equals(temp.getUsername())
					&& roleid == temp.getRoleid())
				return true;
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		return 1;
	}

}

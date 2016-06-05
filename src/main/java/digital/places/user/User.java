package digital.places.user;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import digital.places.root.AppContextJavaProvider;
import digital.places.root.AppMailer;
import digital.places.root.AuthObject;
import digital.places.root.DataService;

@Entity
@Table (name="users")
public class User extends AuthObject implements Serializable
{
    private static final long serialVersionUID = 1L;

	public static final Map<String,String> ULOCATIONS = new HashMap<String,String>();
    static
    {
		ULOCATIONS.put("1","ROLLING MEADOWS, IL");
		ULOCATIONS.put("2","WILMINGTON, DE");
		ULOCATIONS.put("3","RICHMOND, VA");
    }

    public static final Map<Integer,String> ENABLEDS = new HashMap<Integer,String>();
    static
    {
		ENABLEDS.put(1,"ENABLED");
		ENABLEDS.put(0,"DISABLED");
    }

    public static final LinkedHashMap<String,String> UDD = AuthObject.UDD;
    public static final LinkedHashMap<String,String> UMM = AuthObject.UMM;
    public static final LinkedHashMap<String,String> UYYYY = AuthObject.UYYYY;
    
    @Id
    @Column (columnDefinition = "VARCHAR",length = 20)
    private String username;
    
    @Column (columnDefinition = "CHAR",length = 55)
    private String ufname;
    
    @Column (columnDefinition = "CHAR",length = 55)
    private String ulname;

    @Column (columnDefinition = "CHAR",length = 55)
    private String umname;

    @Transient
    private String udobdd;
    
    @Transient
    private String udobmm;
    
    @Transient
    private String udobyyyy;

    @Column (columnDefinition = "DATETIME")
    private Date udob;

    @Transient
    private String ustartdatedd;

    @Transient
    private String ustartdatemm;

    @Transient
    private String ustartdateyyyy;

    @Column (columnDefinition = "DATETIME")
    private Date ustartdate;

    @Transient
    private String uenddatedd;

    @Transient
    private String uenddatemm;

    @Transient
    private String uenddateyyyy;
    
    @Column (columnDefinition = "DATETIME")
    private Date uenddate;
    
    @Column (columnDefinition = "TINYINT")
    private int enabled = 1;

    @Transient
    private int wasEnabled;
    
	@Column (columnDefinition = "CHAR",length = 55)
    private String uemail;
    
    @Column (columnDefinition = "VARCHAR",length = 128)
    private String password;
    
    @Column(columnDefinition = "ENUM('ROLLING MEADOWS, IL','WILMINGTON, DE','RICHMOND, VA')")
    private String ulocation = ULOCATIONS.get("1");
    
    public User() {
		super();
	}

	public User(String inpUsername)
    {
		super();
        this.username = inpUsername;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUfname()
    {
        return ufname;
    }

    public void setUfname(String ufname)
    {
        this.ufname = ufname;
    }

    public String getUlname()
    {
        return ulname;
    }

    public void setUlname(String ulname)
    {
        this.ulname = ulname;
    }

    public String getUmname()
    {
        return umname;
    }

    public void setUmname(String umname)
    {
        this.umname = umname;
    }

    public String getUdobdd()
    {
        return udobdd;
    }

    public void setUdobdd(String udobdd)
    {
        this.udobdd = udobdd;
    }

    public String getUdobmm()
    {
        return udobmm;
    }

    public void setUdobmm(String udobmm)
    {
        this.udobmm = udobmm;
    }

    public String getUdobyyyy()
    {
        return udobyyyy;
    }

    public void setUdobyyyy(String udobyyyy)
    {
        this.udobyyyy = udobyyyy;
    }

    public String getUstartdatedd()
    {
        return ustartdatedd;
    }

    public void setUstartdatedd(String ustartdatedd)
    {
        this.ustartdatedd = ustartdatedd;
    }

    public String getUstartdatemm()
    {
        return ustartdatemm;
    }

    public void setUstartdatemm(String ustartdatemm)
    {
        this.ustartdatemm = ustartdatemm;
    }

    public String getUstartdateyyyy()
    {
        return ustartdateyyyy;
    }

    public void setUstartdateyyyy(String ustartdateyyyy)
    {
        this.ustartdateyyyy = ustartdateyyyy;
    }

    public String getUenddatedd()
    {
        return uenddatedd;
    }

    public void setUenddatedd(String uenddatedd)
    {
        this.uenddatedd = uenddatedd;
    }

    public String getUenddatemm()
    {
        return uenddatemm;
    }

    public void setUenddatemm(String uenddatemm)
    {
        this.uenddatemm = uenddatemm;
    }

    public String getUenddateyyyy()
    {
        return uenddateyyyy;
    }

    public void setUenddateyyyy(String uenddateyyyy)
    {
        this.uenddateyyyy = uenddateyyyy;
    }

    public int getEnabled()
    {
        return enabled;
    }

    public void setEnabled(int enabled)
    {
        this.enabled = enabled;
    }

    public String getUemail()
    {
        return uemail;
    }

    public void setUemail(String uemail)
    {
        this.uemail = uemail;
    }

    @JsonIgnore
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUlocation()
    {
        return ulocation;
    }

    public void setUlocation(String ulocation)
    {
        this.ulocation = ulocation;
    }

    @JsonIgnore
    public Map<String, String> getUDD()
    {
        return UDD;
    }

    @JsonIgnore
    public Map<String, String> getULOCATIONS()
    {
        return ULOCATIONS;
    }

    @JsonIgnore
    public Map<Integer, String> getENABLEDS()
    {
        return ENABLEDS;
    }

    @JsonIgnore
    public Map<String, String> getUMM()
    {
        return UMM;
    }

    @JsonIgnore
    public Map<String, String> getUYYYY()
    {
        return UYYYY;
    }

    @JsonIgnore
    public Map<String, String> getUDOBY()
    {
        return UDOBY;
    }

    public Date getUdob()
    {
        return udob;
    }


    public void setUdob(Date udob)
    {
        this.udob = udob;
    }


    public Date getUstartdate()
    {
        return ustartdate;
    }


    public void setUstartdate(Date ustartdate)
    {
        this.ustartdate = ustartdate;
    }


    public Date getUenddate()
    {
        return uenddate;
    }


    public void setUenddate(Date uenddate)
    {
        this.uenddate = uenddate;
    }

    public int getWasEnabled() {
		return wasEnabled;
	}

	public void setWasEnabled(int wasEnabled) {
		this.wasEnabled = wasEnabled;
	}

    
    
}

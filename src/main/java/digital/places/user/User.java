package digital.places.user;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import digital.places.root.AppConstants;
import digital.places.root.AppContextJavaProvider;
import digital.places.root.AppUtils;
import digital.places.root.DataService;

@Entity
@Table (name="users")
public class User implements Serializable
{
    /**
     * 
     */
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

    
    public static final LinkedHashMap<String,String> UDD = AppConstants.UDD;
    public static final LinkedHashMap<String,String> UMM = AppConstants.UMM;
    public static final LinkedHashMap<String,String> UYYYY = AppConstants.UYYYY;
    public static final LinkedHashMap<String,String> UDOBY = UserConstants.UDOBY;
    
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
    
    @Column (columnDefinition = "CHAR",length = 55)
    private String uemail;
    
    @Column (columnDefinition = "VARCHAR",length = 128)
    private String password;
    
    @Column(columnDefinition = "ENUM('ROLLING MEADOWS, IL','WILMINGTON, DE','RICHMOND, VA')")
    private String ulocation = ULOCATIONS.get("1");
    
    @Transient
    private List<User> cluster;
    
	private DataService getDataService()
    {
		return (DataService) AppContextJavaProvider.getApplicationContext().getBean("dataService");
    }
    
    List<User> findAllByUsername(String username)
    {
    	String sql = "select u from User u where username like '%"+StringUtils.trimAllWhitespace(username)+"%'";
		DataService dataService = getDataService();
    	return (List<User>)dataService.query(sql);
    }
    
    User findInDatastore()
    {
    	String sql = "select u from User u where username = '"+StringUtils.trimAllWhitespace(username)+"'";
		DataService dataService = getDataService();
		List<User> users = (List<User>)dataService.query(sql);
		if (users != null && users.size() > 0)
		{
			dissolve(users.get(0));
		}
    	return this;
    }

    User prepUpdate()
    {
    	Calendar cal = Calendar.getInstance();
    	if (udob != null)
    	{
        	cal.setTime(udob);
    		udobdd = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
    		udobmm = String.valueOf(cal.get(Calendar.MONTH));
    		udobyyyy = String.valueOf(cal.get(Calendar.YEAR));
    	}

    	if (ustartdate != null)
    	{
        	cal.setTime(ustartdate);
    		ustartdatedd = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
    		ustartdatemm = String.valueOf(cal.get(Calendar.MONTH));
    		ustartdateyyyy = String.valueOf(cal.get(Calendar.YEAR));
    	}

    	if (uenddate != null)
    	{
        	cal.setTime(uenddate);
    		uenddatedd = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
    		uenddatemm = String.valueOf(cal.get(Calendar.MONTH));
    		uenddateyyyy = String.valueOf(cal.get(Calendar.YEAR));
    	}

    	return this;
    }
    
    void update() throws ParseException
    {
    	prepStore();
		DataService dataService = getDataService();
		dataService.update(this);
    }
    
    private void dissolve(Object obj)
    {
    	if (obj instanceof User)
    	{
    		User user = (User) obj;
    		this.cluster = user.getCluster();
    		this.enabled = user.getEnabled();
    		this.password = user.getPassword();
    		this.udob = user.getUdob();
    		this.udobdd = user.getUdobdd();
    		this.udobmm = user.getUdobmm();
    		this.udobyyyy = user.getUdobyyyy();
    		this.uemail = user.getUemail();
    		this.uenddate = user.getUenddate();
    		this.uenddatedd = user.getUenddatedd();
    		this.uenddatemm = user.getUenddatemm();
    		this.uenddateyyyy = user.getUenddateyyyy();
    		this.ufname = user.getUfname();
    		this.ulname = user.getUlname();
    		this.ulocation = user.getUlocation();
    		this.umname = user.getUmname();
    		this.username = user.getUsername();
    		this.ustartdate = user.getUstartdate();
    		this.ustartdatedd = user.getUstartdatedd();
    		this.ustartdatemm = user.getUstartdatemm();
    		this.ustartdateyyyy = user.getUstartdateyyyy();
    	}
    }
    
    public User identify(String inpUsername)
    {
        this.username = inpUsername;
        return this;
    }

    void addToDatastore() throws ParseException 
    {
    	prepStore();
		DataService dataService = getDataService();
		dataService.create(this);
    }
    
    void prepStore() throws ParseException
    {
		setUdob(AppUtils.parseDate(this.udobdd,this.udobmm,this.udobyyyy));
		setUstartdate(AppUtils.parseDate(this.ustartdatedd,this.ustartdatemm,this.ustartdateyyyy));
		if (!StringUtils.isEmpty(this.uenddatedd))
		{
		    try
		    {
		    	setUenddate(AppUtils.parseDate(this.uenddatedd,this.uenddatemm,this.uenddateyyyy));
		    }
		    catch (Exception e)
		    {
		    	e.printStackTrace();
		    }
		}
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

    @Override
    public String toString()
    {
	return this.username;
    }

    public Map<String, String> getUDD()
    {
        return UDD;
    }

    public Map<String, String> getULOCATIONS()
    {
        return ULOCATIONS;
    }

    public Map<Integer, String> getENABLEDS()
    {
        return ENABLEDS;
    }

    public Map<String, String> getUMM()
    {
        return UMM;
    }

    public Map<String, String> getUYYYY()
    {
        return UYYYY;
    }

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

    public List<User> getCluster() {
		return cluster;
	}

	public void setCluster(List<User> cluster) {
		this.cluster = cluster;
	}

    
    
}

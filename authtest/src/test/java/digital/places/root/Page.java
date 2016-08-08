package digital.places.root;

public class Page
{
	private String url;
	private String title;
	private String metaDescription;
	private String loginId;
	private String password;
	
	public String getLoginId()
	{
		return loginId;
	}
	public void setLoginId(String loginId)
	{
		this.loginId = loginId;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getMetaDescription()
	{
		return metaDescription;
	}
	public void setMetaDescription(String metaDescription)
	{
		this.metaDescription = metaDescription;
	}
}

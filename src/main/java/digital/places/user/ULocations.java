package digital.places.user;

public enum ULocations
{
    RM("ROLLING MEADOWS, IL"),
    WD("WILMINGTON, DE"),
    RV("RICHMOND, VA");

    private String location;

    private ULocations(String arg0)
    {
	location = arg0;
    }
    
    public String getLocation() {
	return location;
    }
    
}

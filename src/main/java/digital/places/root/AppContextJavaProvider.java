package digital.places.root;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AppContextJavaProvider implements ApplicationContextAware
{

	private static ApplicationContext context;

	public static ApplicationContext getApplicationContext()
	{
		return context;
	}

	@Override
	public void setApplicationContext(ApplicationContext ac) throws BeansException
	{
		context = ac;
	}

}

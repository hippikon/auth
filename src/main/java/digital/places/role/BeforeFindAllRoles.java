package digital.places.role;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import digital.places.root.AppContextJavaProvider;
import digital.places.root.DataService;

public class BeforeFindAllRoles implements MethodBeforeAdvice
{
	@Override
	public void before(Method method, Object[] args, Object target)
		throws Throwable 
	{
		if (Role.allRoles == null)
		{
			DataService dataService = (DataService) AppContextJavaProvider.getApplicationContext().getBean("dataService");
	        Role.findAll(dataService);
		}
	}
}
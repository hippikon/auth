package digital.places.user;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

class ServletContextJavaProvider implements ServletContextAware
{
    private static ServletContext servletContext;
    
    public static ServletContext getServletContext()
    {
        return servletContext;
    }

    @Override
    public void setServletContext(ServletContext arg0)
    {
	servletContext = arg0;
    }
}

package digital.places.root;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceProps
{
    PersistenceProps props;

    @Autowired
	ServletContext servletContext;
    
    @Autowired
    public void setProps(PersistenceProps props)
    {
        this.props = props;
    }

    public void create(final Object obj)
    {
    	props.getEntityManager().persist(obj);
    }
}

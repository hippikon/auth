package digital.places.root;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DataService
{
    DataStore dataStore;

    @Autowired
	ServletContext servletContext;
    
    @Autowired
    public void setDataStore(DataStore dataStore)
    {
        this.dataStore = dataStore;
    }

    public void create(final Object obj)
    {
    	dataStore.getEntityManager().persist(obj);
    }

    public void update(final Object obj)
    {
    	dataStore.getEntityManager().merge(obj);
    }

    public List query(final String queryString)
    {
    	return dataStore.getEntityManager().createQuery(queryString).getResultList();
    }

    public void delete(final Object obj)
    {
    	dataStore.getEntityManager().remove(obj);
    }
}

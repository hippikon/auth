package digital.places.root;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class DataStore
{
    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager()
    {
        return entityManager;
    }

}

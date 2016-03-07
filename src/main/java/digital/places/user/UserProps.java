package digital.places.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import digital.places.root.AppProps;

@Service
@Transactional
class UserProps
{
    AppProps props;

    public void create(final User user)
    {
	props.getEntityManager().persist(user);
    }

    @Autowired
    public void setProps(AppProps props)
    {
        this.props = props;
    }
    
}

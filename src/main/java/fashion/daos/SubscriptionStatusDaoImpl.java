package fashion.daos;

import fashion.entity.SubscriptionStatus;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class SubscriptionStatusDaoImpl extends SuperDao implements SubscriptionStatusDao{

    @Override
    public SubscriptionStatus findById(short id) {
        return(getSession().createNamedQuery("SubscriptionStatus.findById", SubscriptionStatus.class).setParameter("id", id).getSingleResult());
    }

    @Override
    public List<SubscriptionStatus> getAllSubscriptionStatus() {
        return(getSession().createNamedQuery("SubscriptionStatus.findAll",SubscriptionStatus.class).getResultList());
    }
    
}

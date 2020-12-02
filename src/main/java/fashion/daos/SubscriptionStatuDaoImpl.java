package fashion.daos;

import fashion.entity.SubscriptionStatus;
import org.springframework.stereotype.Repository;

@Repository
public class SubscriptionStatuDaoImpl extends SuperDao implements SubscriptionStatuDao{

    @Override
    public SubscriptionStatus findById(short id) {
        return(getSession().createNamedQuery("SubscriptionStatu.findById", SubscriptionStatus.class).setParameter("id", id).getSingleResult());
    }
    
}

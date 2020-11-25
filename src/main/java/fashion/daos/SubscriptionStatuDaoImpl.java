package fashion.daos;

import fashion.entity.SubscriptionStatu;
import org.springframework.stereotype.Repository;

@Repository
public class SubscriptionStatuDaoImpl extends SuperDao implements SubscriptionStatuDao{

    @Override
    public SubscriptionStatu findById(short id) {
        return(getSession().createNamedQuery("SubscriptionStatu.findById", SubscriptionStatu.class).setParameter("id", id).getSingleResult());
    }
    
}

package fashion.daos;

import fashion.entity.SubscriptionStatus;


public interface SubscriptionStatuDao {

    public SubscriptionStatus findById(short id);
    
}

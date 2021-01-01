package fashion.daos;

import fashion.entity.SubscriptionStatus;
import java.util.List;


public interface SubscriptionStatusDao {

    public SubscriptionStatus findById(short id);

    public List<SubscriptionStatus> getAllSubscriptionStatus();
    
}

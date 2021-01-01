package fashion.services;

import fashion.entity.SubscriptionStatus;
import java.util.List;


public interface SubscriptionStatusService {

    public SubscriptionStatus findById(short id);

    public List<SubscriptionStatus> getAllSubscriptionStatus();
    
}

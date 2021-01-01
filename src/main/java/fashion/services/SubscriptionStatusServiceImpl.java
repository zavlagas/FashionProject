package fashion.services;

import fashion.entity.SubscriptionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fashion.daos.SubscriptionStatusDao;
import java.util.List;

@Service
@Transactional
public class SubscriptionStatusServiceImpl implements SubscriptionStatusService{
    @Autowired
    private SubscriptionStatusDao dao;

    @Override
    public SubscriptionStatus findById(short id) {
        return(dao.findById(id));
    }

    @Override
    public List<SubscriptionStatus> getAllSubscriptionStatus() {
       return (dao.getAllSubscriptionStatus());
    }
}

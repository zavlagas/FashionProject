package fashion.services;

import fashion.daos.SubscriptionStatuDao;
import fashion.entity.SubscriptionStatu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubscriptionStatuServiceImpl implements SubscriptionStatuService{
    @Autowired
    private SubscriptionStatuDao dao;

    @Override
    public SubscriptionStatu findById(short id) {
        return(dao.findById(id));
    }
}

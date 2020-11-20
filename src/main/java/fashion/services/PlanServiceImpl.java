package fashion.services;

import fashion.daos.PlanDao;
import fashion.entity.Plan;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanDao dao;

    @Override
    public List<Plan> getAllPlans() {
        return (dao.findAllPlans());
    }

}

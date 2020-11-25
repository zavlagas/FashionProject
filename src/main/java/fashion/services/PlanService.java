package fashion.services;

import fashion.entity.Plan;
import java.util.List;

public interface PlanService {

    List<Plan> getAllPlans();
    
    public Plan findById(short id);

}

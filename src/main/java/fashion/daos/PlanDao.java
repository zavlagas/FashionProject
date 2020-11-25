package fashion.daos;

import fashion.entity.Plan;
import java.util.List;


public interface PlanDao {

    List<Plan> findAllPlans();
    
    public Plan findById(short id);

}

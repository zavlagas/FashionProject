package fashion.daos;

import fashion.entity.Plan;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PlanDaoImpl extends SuperDao implements PlanDao {

    @Override
    public List<Plan> findAllPlans() {
        return (getSession().createNamedQuery("Plan.findAll", Plan.class).getResultList());
    }

    @Override
    public Plan findById(short id) {
        return(getSession().createNamedQuery("Plan.findById", Plan.class).setParameter("id", id).getSingleResult());
    }

}

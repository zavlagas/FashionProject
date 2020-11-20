/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

}

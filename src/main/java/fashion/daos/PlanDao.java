/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.daos;

import fashion.entity.Plan;
import java.util.List;

/**
 *
 * @author User
 */
public interface PlanDao {

    List<Plan> findAllPlans();

}

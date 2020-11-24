/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.daos;

import fashion.entity.UserSubscription;

/**
 *
 * @author User
 */
public class UserSubscriptionDaoImpl extends SuperDao implements UserSubscriptionDao {
    
    
    @Override
    public void register(UserSubscription newUserSubscription) {
        getSession().save(newUserSubscription);
    }

}

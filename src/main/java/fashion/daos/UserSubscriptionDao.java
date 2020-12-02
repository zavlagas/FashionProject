/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.daos;

import fashion.entity.User;
import fashion.entity.UserSubscription;

/**
 *
 * @author User
 */
public interface UserSubscriptionDao {

    void register(UserSubscription newUserSubscription);

    public boolean checkIfUserExistsInDb(User newUser);

}

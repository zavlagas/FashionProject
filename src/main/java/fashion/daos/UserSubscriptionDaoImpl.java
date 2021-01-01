/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.daos;

import fashion.entity.User;
import fashion.entity.UserSubscription;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;

@Repository
public class UserSubscriptionDaoImpl extends SuperDao implements UserSubscriptionDao {

    @Override
    public void register(UserSubscription newUserSubscription) {
        getSession().save(newUserSubscription);
    }

    @Override
    public User checkIfUserExistsInDb(User newUser) {
        return (getSession().createNamedQuery("User.findByUid",User.class).setParameter("id", newUser.getId()).uniqueResult());
    }

}

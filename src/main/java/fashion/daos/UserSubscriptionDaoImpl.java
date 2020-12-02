/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.daos;

import fashion.entity.User;
import fashion.entity.UserSubscription;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UserSubscriptionDaoImpl extends SuperDao implements UserSubscriptionDao {

    @Override
    public void register(UserSubscription newUserSubscription) {
        getSession().save(newUserSubscription);
    }

    @Override
    public boolean checkIfUserExistsInDb(User newUser) {
        boolean userExist = true;
        try {
            getSession().createNamedQuery("User.findByUsername", User.class).getSingleResult();
        } catch (NoResultException e) {
            userExist = false;
        }
        return (userExist);

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.services;

import fashion.daos.UserSubscriptionDao;
import fashion.entity.UserSubscription;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author User
 */
public class UserSubscriptionServiceImpl implements UserSubscriptionService {

    @Autowired
    private UserSubscriptionDao dao;

    @Override
    public String register(UserSubscription newSubscription) {
        return (dao.register(newSubscription));
    }

}

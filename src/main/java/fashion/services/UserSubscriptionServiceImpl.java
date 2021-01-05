/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.services;

import fashion.daos.UserSubscriptionDao;
import fashion.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserSubscriptionServiceImpl implements UserSubscriptionService {

//    @Autowired
//    private UserSubscriptionDao dao;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public String checkIfUserExistsInDbAndIfNotRegisterThe(UserSubscription newUserSubscription) {
//        String processInfo = "";
//        User userExists = dao.checkIfUserExistsInDb(newUserSubscription.getUser());
//        if(userExists != null){
//            dao.register(newUserSubscription);
//            processInfo = "User Subscription Completed";
//        }else{
//            processInfo = "User Exists , Try Again With Different Credentials";
//        }
//        return (processInfo);
//    }
//
//    @Override
//    public void register(UserSubscription newUserSubscription) {
//        newUserSubscription
//                .getUser()
//                .setPassword(passwordEncoder.encode(newUserSubscription.getUser().getPassword()));
//        dao.register(newUserSubscription);
//    }

}

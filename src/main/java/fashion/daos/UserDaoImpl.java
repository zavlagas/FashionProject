/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.daos;

import fashion.entity.User;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl extends SuperDao implements UserDao {

    @Override
    public User findByUsername(String username) {
        return (getSession()
                .createNamedQuery("User.findByUsername", User.class)
                .setParameter("username", username)
                .getSingleResult());
    }

}

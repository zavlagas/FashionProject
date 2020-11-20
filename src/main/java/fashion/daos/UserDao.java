/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.daos;

import fashion.entity.User;

/**
 *
 * @author User
 */
public interface UserDao {

    User findByUsername(String username);

    public int registerUserToDb(User newUser);

    

}

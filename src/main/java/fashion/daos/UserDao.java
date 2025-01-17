/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.daos;

import fashion.entity.Product;
import fashion.entity.User;
import java.util.List;

/**
 *
 * @author User
 */
public interface UserDao {

    fashion.entity.User findByUsername(String username);
    
    fashion.entity.User fetchAllUserDetails(String username);

    public void signUpToDatabase(User newUser);

    public User findUserById(int userId);

    public boolean updateUserDetails(User oldUserDetails);

    public boolean deleteUserFromDb(int id);

}

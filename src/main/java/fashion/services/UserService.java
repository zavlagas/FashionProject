package fashion.services;

import fashion.entity.Product;
import fashion.entity.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User getAuthorizedUser(String username);

    public boolean signUpNewUserIfNotExists(User newUser);

    public boolean updateNewUserDetails(User oldUserDetails);
    
    public User getAllUserDetails(String username);
    
    
    public User findUserById(int id);

    public boolean deleteUserFromDb(int id);
}

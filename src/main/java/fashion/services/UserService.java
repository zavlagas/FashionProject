package fashion.services;

import fashion.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    
     public User getAuthorizedUser(String username);
    
}

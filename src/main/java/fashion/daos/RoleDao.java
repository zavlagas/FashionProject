package fashion.daos;

import fashion.entity.Role;
import java.util.List;


public interface RoleDao {
    
    List<Role> findAllRoles();
}

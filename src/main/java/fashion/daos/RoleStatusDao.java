package fashion.daos;

import fashion.entity.RoleStatu;
import javax.management.relation.RoleStatus;


public interface RoleStatusDao {

    public RoleStatu findByRoleStatus(short id);
    
}

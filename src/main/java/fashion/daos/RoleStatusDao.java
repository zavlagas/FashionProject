package fashion.daos;

import fashion.entity.RoleStatus;


public interface RoleStatusDao {

    public RoleStatus findByRoleStatus(short id);
    
}

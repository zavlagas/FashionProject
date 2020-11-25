package fashion.services;

import fashion.entity.RoleStatu;
import javax.management.relation.RoleStatus;


public interface RoleStatusService {
    
    public RoleStatu findByRoleStatus(short id);
    
}

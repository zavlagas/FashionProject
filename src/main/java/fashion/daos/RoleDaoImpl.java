package fashion.daos;

import fashion.entity.Role;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends SuperDao implements RoleDao{
    
    @Override
    public List<Role> findAllRoles(){
        return(getSession().createNamedQuery("Role.findAll", Role.class).getResultList());
    }
    
}

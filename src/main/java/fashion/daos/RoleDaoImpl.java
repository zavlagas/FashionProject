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

    @Override
    public Role findById(short id) {
        return(getSession().createNamedQuery("Role.findById", Role.class).setParameter("id", id).getSingleResult());
    }
    
}

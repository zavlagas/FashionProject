package fashion.daos;

import fashion.entity.RoleStatu;
import org.springframework.stereotype.Repository;

@Repository
public class RoleStatusDaoImpl extends SuperDao implements RoleStatusDao {

    @Override
    public RoleStatu findByRoleStatus(short id) {
        return(getSession().createNamedQuery("RoleStatu.findById", RoleStatu.class).setParameter("id", id).getSingleResult());
    }
    
}

package fashion.daos;

import fashion.entity.RoleStatus;
import org.springframework.stereotype.Repository;

@Repository
public class RoleStatusDaoImpl extends SuperDao implements RoleStatusDao {

    @Override
    public RoleStatus findByRoleStatus(short id) {
        return(getSession().createNamedQuery("RoleStatu.findById", RoleStatus.class).setParameter("id", id).getSingleResult());
    }
    
}

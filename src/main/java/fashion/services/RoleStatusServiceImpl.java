package fashion.services;

import fashion.daos.RoleStatusDao;
import fashion.entity.RoleStatu;
import javax.management.relation.RoleStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleStatusServiceImpl implements RoleStatusService {
    @Autowired
    private RoleStatusDao dao;

    @Override
    public RoleStatu findByRoleStatus(short id) {
        return(dao.findByRoleStatus(id));
    }

}

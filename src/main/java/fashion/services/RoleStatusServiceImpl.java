package fashion.services;

import fashion.daos.RoleStatusDao;
import fashion.entity.RoleStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleStatusServiceImpl implements RoleStatusService {
    @Autowired
    private RoleStatusDao dao;

    @Override
    public RoleStatus findByRoleStatus(short id) {
        return(dao.findByRoleStatus(id));
    }

}

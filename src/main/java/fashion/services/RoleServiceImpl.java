package fashion.services;

import fashion.daos.RoleDao;
import fashion.entity.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao dao;

    @Override
    public List<Role> getAllRoles() {
        return (dao.findAllRoles());
    }

    @Override
    public Role findByRole(short id) {
        return (dao.findById(id));
    }

}

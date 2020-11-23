package fashion.daos;

import fashion.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends SuperDao implements UserDao {

    @Override
    public User findByUsername(String username) {
        return (getSession()
                .createNamedQuery("User.findByUsername", User.class)
                .setParameter("username", username)
                .getSingleResult());
    }

}

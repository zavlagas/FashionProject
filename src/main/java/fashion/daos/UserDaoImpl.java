package fashion.daos;

import fashion.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends SuperDao implements UserDao {

    @Override
    public fashion.entity.User findByUsername(String username) {
        return (getSession()
                .createNamedQuery("User.findByUsername", User.class)
                .setParameter("username", username)
                .uniqueResult());
    }

    @Override
    public User fetchAllUserDetails(String username) {
        return (getSession()
                .createNamedQuery("User.findAllDetailsByUsername", User.class)
                .setParameter("username", username)
                .uniqueResult());
    }

    @Override
    public void signUpToDatabase(User newUser) {
        getSession().save(newUser);
    }

}

package fashion.daos;

import fashion.entity.User;
import java.io.Serializable;
import org.hibernate.Session;
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

    @Override
    public int registerUserToDb(User newUser) {
       Session session = getSession();
        int id = (int)session.save(newUser);
        return id;
    }

}

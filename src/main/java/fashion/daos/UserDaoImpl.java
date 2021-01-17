package fashion.daos;

import fashion.entity.Product;
import fashion.entity.User;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;
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
    public void signUpToDatabase(User newUser) {
        getSession().save(newUser);
    }

    @Override
    public User findUserById(int userId) {
        return (getSession().createNamedQuery("User.findById", User.class)
                .setParameter("id", userId).uniqueResult());
    }

    @Override
    public boolean updateUserDetails(User oldUserDetails) {
        boolean isUpdated = false;
        try {
            getSession().saveOrUpdate(oldUserDetails);
            isUpdated = true;

        } catch (ConstraintViolationException e) {
            System.out.println(e.fillInStackTrace());
        }
        return (isUpdated);
    }

    @Override
    public User fetchAllUserDetails(String username) {
        return(getSession()
                .createNamedQuery("User.findAllDetailsByUsername", User.class)
                .setParameter("username", username).uniqueResult());
    }

}

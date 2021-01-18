package fashion.daos;

import fashion.entity.User;
import org.hibernate.JDBCException;
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

    @Override
    public boolean deleteUserFromDb(int id) {
        boolean isDeleted = false;
        User userForDelete = findUserById(id);
        try {
            getSession().delete(userForDelete);
            isDeleted = true;
        } catch (JDBCException e) {
            System.out.println(e.fillInStackTrace());
        }
        return(isDeleted);
    }

}

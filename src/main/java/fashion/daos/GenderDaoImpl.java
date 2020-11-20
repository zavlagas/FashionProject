package fashion.daos;

import fashion.entity.Gender;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class GenderDaoImpl extends SuperDao implements GenderDao {

    @Override
    public List<Gender> findAllGenders() {
        return (getSession().createNamedQuery("Gender.findAll", Gender.class).getResultList());
    }
    
    
    
    
}

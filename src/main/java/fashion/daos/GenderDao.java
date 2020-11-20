package fashion.daos;

import fashion.entity.Gender;
import java.util.List;


public interface GenderDao {
    
    List<Gender> findAllGenders();
    
    
    
}

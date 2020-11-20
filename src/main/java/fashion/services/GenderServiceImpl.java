package fashion.services;

import fashion.daos.GenderDao;
import fashion.entity.Gender;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GenderServiceImpl implements GenderService{

    @Autowired
    private GenderDao dao; 
    
    @Override
    public List<Gender> getAllGenders() {
        return(dao.findAllGenders());
    }
    
}

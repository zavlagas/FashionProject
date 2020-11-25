package fashion.services;

import fashion.daos.PayMethodDao;
import fashion.entity.PayMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PayMethodServiseImpl implements PayMethodService {
    @Autowired
    private PayMethodDao dao; 

    @Override
    public PayMethod findByPaymentMethod(int id) {
        return(dao.findByPaymentMethod(id));
    }
}

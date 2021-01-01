package fashion.services;

import fashion.daos.PayMethodDao;
import fashion.entity.PayMethod;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PayMethodServiceImpl implements PayMethodService {
    @Autowired
    private PayMethodDao dao; 

    @Override
    public PayMethod findByPaymentMethod(short id) {
        return(dao.findByPaymentMethod(id));
    }

    @Override
    public List<PayMethod> getAllPaymentMethods() {
        return (dao.getAllPaymentMethods());
    }
}

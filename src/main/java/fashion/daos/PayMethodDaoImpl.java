package fashion.daos;

import fashion.entity.PayMethod;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PayMethodDaoImpl extends SuperDao implements PayMethodDao {

    @Override
    public PayMethod findByPaymentMethod(short id) {
        return(getSession().createNamedQuery("PayMethod.findById", PayMethod.class).setParameter("id", id).getSingleResult());
    }

    @Override
    public List<PayMethod> getAllPaymentMethods() {
        return (getSession().createNamedQuery("PayMethod.findAll", PayMethod.class).getResultList());
    }
    
}

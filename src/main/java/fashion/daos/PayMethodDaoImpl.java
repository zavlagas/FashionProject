package fashion.daos;

import fashion.entity.PayMethod;
import org.springframework.stereotype.Repository;

@Repository
public class PayMethodDaoImpl extends SuperDao implements PayMethodDao {

    @Override
    public PayMethod findByPaymentMethod(short id) {
        return(getSession().createNamedQuery("PayMethod.findById", PayMethod.class).setParameter("id", id).getSingleResult());
    }
    
}

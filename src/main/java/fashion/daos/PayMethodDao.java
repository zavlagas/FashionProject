package fashion.daos;

import fashion.entity.PayMethod;
import java.util.List;


public interface PayMethodDao {
    public PayMethod findByPaymentMethod(short id);

    public List<PayMethod> getAllPaymentMethods();
}

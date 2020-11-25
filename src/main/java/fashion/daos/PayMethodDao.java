package fashion.daos;

import fashion.entity.PayMethod;


public interface PayMethodDao {
    public PayMethod findByPaymentMethod(int id);
}

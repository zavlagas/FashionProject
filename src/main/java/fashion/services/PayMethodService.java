package fashion.services;

import fashion.entity.PayMethod;


public interface PayMethodService {
    public PayMethod findByPaymentMethod(int id);
}

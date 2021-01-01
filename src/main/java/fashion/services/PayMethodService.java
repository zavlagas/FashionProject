package fashion.services;

import fashion.entity.PayMethod;
import java.util.List;


public interface PayMethodService {
    public PayMethod findByPaymentMethod(short id);

    public List<PayMethod> getAllPaymentMethods();
}

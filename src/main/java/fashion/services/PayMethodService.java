package fashion.services;

import com.stripe.exception.StripeException;
import fashion.entity.PayMethod;
import fashion.entity.PaymentRequest;
import java.util.List;


public interface PayMethodService {
    public PayMethod findByPaymentMethod(short id);

    public List<PayMethod> getAllPaymentMethods();

    public String charge(PaymentRequest request) throws StripeException;
}

package fashion.services;

import com.stripe.exception.StripeException;
import fashion.entity.PaymentRequest;


public interface PayMethodService {

    public String charge(PaymentRequest request) throws StripeException;
}

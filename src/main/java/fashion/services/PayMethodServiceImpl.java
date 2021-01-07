package fashion.services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import fashion.daos.PayMethodDao;
import fashion.entity.PayMethod;
import fashion.entity.PaymentRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PayMethodServiceImpl implements PayMethodService {

    @Autowired
    private PayMethodDao dao;

    private final String secretKey = "sk_test_51I6V9NDhiMmdhGSnNnkf5o0ksEC8Fw2Flq69zueZfbcPYdzQF6v6kQxSl4vduIvMsH2NUVS4KVM6ANt2XSpfEc1600c7JNW68o";

    @Override
    public PayMethod findByPaymentMethod(short id) {
        return (dao.findByPaymentMethod(id));
    }

    @Override
    public List<PayMethod> getAllPaymentMethods() {
        return (dao.getAllPaymentMethods());
    }

    @PostConstruct
    public void init() {
        Stripe.apiKey = this.secretKey;
    }

    @Override
    public String charge(PaymentRequest chargeRequest) throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", PaymentRequest.Currency.EUR);
        chargeParams.put("source", chargeRequest.getToken().getId());

        Charge charge = Charge.create(chargeParams);
        return charge.getId();
    }
}

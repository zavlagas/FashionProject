package fashion.entity.converters;

import fashion.entity.PayMethod;
import fashion.services.PayMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class StringToPayMethodConverter implements Converter<String, PayMethod> {
    
    @Autowired
    private PayMethodService service;

    @Override
    public PayMethod convert(String s) {
        int id = Integer.parseInt(s);
        PayMethod payMethod = service.findByPaymentMethod(id);
        return(payMethod);
                
    }
    
    
    
}

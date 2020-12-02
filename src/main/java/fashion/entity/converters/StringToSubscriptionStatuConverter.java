package fashion.entity.converters;

import fashion.entity.SubscriptionStatus;
import fashion.services.SubscriptionStatuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToSubscriptionStatuConverter implements Converter<String, SubscriptionStatus> {

    @Autowired
    private SubscriptionStatuService service;
    
    @Override
    public SubscriptionStatus convert(String s) {
        short id = Short.parseShort(s);
        SubscriptionStatus status = service.findById(id);
        return(status);
    }
    
    
}

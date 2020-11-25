package fashion.entity.converters;

import fashion.entity.SubscriptionStatu;
import fashion.services.SubscriptionStatuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class StringToSubscriptionStatuConverter implements Converter<String, SubscriptionStatu> {

    @Autowired
    private SubscriptionStatuService service;
    
    @Override
    public SubscriptionStatu convert(String s) {
        int id = Integer.parseInt(s);
        SubscriptionStatu status = service.findById(id);
        return(status);
    }
    
    
}

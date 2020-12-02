package fashion.entity.converters;

import fashion.entity.Plan;
import fashion.services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToPlanConverter implements Converter<String, Plan> {

    @Autowired
    private PlanService service;
    
    @Override
    public Plan convert(String s) {
        short id = Short.parseShort(s);
        Plan plan = service.findById(id);
        return(plan);
    }
    
}

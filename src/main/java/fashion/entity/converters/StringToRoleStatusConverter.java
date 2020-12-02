package fashion.entity.converters;

import fashion.entity.RoleStatus;
import fashion.services.RoleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToRoleStatusConverter implements Converter<String, RoleStatus> {

    @Autowired
    private RoleStatusService service;

    @Override
    public RoleStatus convert(String s) {
        short id = Short.parseShort(s);
        RoleStatus status = service.findByRoleStatus(id);
        return(status);
    }

}

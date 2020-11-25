package fashion.entity.converters;

import fashion.entity.RoleStatu;
import fashion.services.RoleStatusService;
import javax.management.relation.RoleStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToRoleStatusConverter implements Converter<String, RoleStatu> {

    @Autowired
    private RoleStatusService service;

    @Override
    public RoleStatu convert(String s) {
        short id = Short.parseShort(s);
        RoleStatu status = service.findByRoleStatus(id);
        return(status);
    }

}

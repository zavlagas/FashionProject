package fashion.entity.converters;

import fashion.entity.Role;
import fashion.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToRoleConverter implements Converter<String, Role> {

    @Autowired
    private RoleService service;
    
    @Override
    public Role convert(String s) {
        short id = Short.parseShort(s);
        Role role = service.findByRole(id);
        return(role);
    }
    
}

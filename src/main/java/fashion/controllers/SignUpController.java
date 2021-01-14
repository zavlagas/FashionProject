package fashion.controllers;

import fashion.entity.User;
import fashion.services.PlanService;
import fashion.services.RoleService;
import fashion.services.UserService;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SignUpController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private PlanService planService;
    @Autowired
    private UserService service;
    
      
    @PostMapping("/signup")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Boolean> signUpNewUser(@RequestBody User newUser) {
        boolean userExists = service.signUpNewUserIfNotExists(newUser);
        return (ResponseEntity.ok().body(userExists));
    }
  

}

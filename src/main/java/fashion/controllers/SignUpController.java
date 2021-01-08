package fashion.controllers;

import fashion.entity.User;
import fashion.services.PlanService;
import fashion.services.RoleService;
import fashion.services.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

//    @GetMapping("/signup")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<List<?>>> getAllDropDownListInformations() {
        List<List<?>> dropDownLists = new ArrayList<>();
        dropDownLists.add(roleService.getAllRoles());
        dropDownLists.add(planService.getAllPlans());
        return ResponseEntity.ok().body(dropDownLists);
    }
    
      
    @PutMapping("/signup")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Boolean> signUpNewUser(@RequestBody User newUser) {
        boolean userExists = service.signUpNewUserIfNotExists(newUser);
        return (ResponseEntity.ok().body(userExists));
    }
     @GetMapping("/signup")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<User> testJsonUser(){
        User testUser = service.getAuthorizedUser("admin");
        return ResponseEntity.ok().body(testUser);
    }

}

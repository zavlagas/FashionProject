package fashion.controllers;

import fashion.entity.UserSubscription;
import fashion.services.GenderService;
import fashion.services.PayMethodService;
import fashion.services.PlanService;
import fashion.services.RoleService;
import fashion.services.SubscriptionStatusService;
import fashion.services.UserSubscriptionService;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class SignUpController {

    @Autowired
    private GenderService genderService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PlanService planService;
    @Autowired
    private SubscriptionStatusService subscriptionStatusService;
    @Autowired
    private PayMethodService payMethodService;
    @Autowired
    private UserSubscriptionService userSubscriptionService;

    @GetMapping("/signup")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<List<?>>> getAllDropDownListInformations() {
        List<List<?>> dropDownLists = new ArrayList<>();
        dropDownLists.add(genderService.getAllGenders());
        dropDownLists.add(roleService.getAllRoles());
        dropDownLists.add(planService.getAllPlans());
        dropDownLists.add(subscriptionStatusService.getAllSubscriptionStatus());
        dropDownLists.add(payMethodService.getAllPaymentMethods());
        return ResponseEntity.ok().body(dropDownLists);
    }

    @PutMapping("/signup")
    public ResponseEntity<?> signUpNewUser(@RequestBody UserSubscription userSubscription) {
        String processInfo = userSubscriptionService.checkIfUserExistsInDbAndIfNotRegisterThe(userSubscription);
        return (ResponseEntity.ok().body(processInfo));
    }

}

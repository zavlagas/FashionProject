package fashion.controllers;

import fashion.entity.Gender;
import fashion.entity.Plan;
import fashion.entity.Role;
import fashion.entity.UserSubscription;
import fashion.services.GenderService;
import fashion.services.PlanService;
import fashion.services.RoleService;
import fashion.services.UserSubscriptionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    private GenderService genderService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PlanService planService;
    @Autowired
    private UserSubscriptionService userSubscriptionService;

    @ModelAttribute("genders")
    private List<Gender> getGenders() {
        return (genderService.getAllGenders());
    }

    @ModelAttribute("roles")
    private List<Role> getRoles() {
        return (roleService.getAllRoles());
    }

    @ModelAttribute("plans")
    private List<Plan> getPlans() {
        return (planService.getAllPlans());
    }Str

    @GetMapping
    private String getSignUpPageForCreatingANewUser(Model model) {
        model.addAttribute("user_subscription", new UserSubscription());
        return ("/authentication/signup");
    }

    @PostMapping
    private String registerUser(@ModelAttribute("user_subscription") UserSubscription newUserSubscription, RedirectAttributes ra) {
        String message = userSubscriptionService.checkIfUserExistsInDbAndIfNotRegisterThe(newUserSubscription);
        ra.addAttribute("exists", message);
        return ("redirect:/loginPage");
    }

}

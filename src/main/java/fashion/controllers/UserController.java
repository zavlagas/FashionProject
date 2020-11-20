package fashion.controllers;

import fashion.entity.Gender;
import fashion.entity.Plan;
import fashion.entity.Role;
import fashion.entity.User;
import fashion.services.GenderService;
import fashion.services.PlanService;
import fashion.services.RoleService;
import fashion.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class UserController {

    @Autowired
    private GenderService genderService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PlanService planService;
    @Autowired
    private UserService userService;

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
    }

    @GetMapping("/signup")
    private String getSignUpPageForCreatingANewUser(Model model) {
        model.addAttribute("user", new User());
        return ("/authentication/signup");
    }

    @PostMapping("/singup")
    private String registerUser(@ModelAttribute("user")User newUser,RedirectAttributes ra){
        String proccessInfo=userService.registerUserClient(newUser);
        ra.addAttribute("message",proccessInfo);
        return("redirect:/loginPage");
        
    }
}

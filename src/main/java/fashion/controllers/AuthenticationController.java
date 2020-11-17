/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthenticationController {

    @RequestMapping("/loginPage")
    private String getLoginPage() {
        return ("login");
    }
    
    @GetMapping("/access-denied")
    private String showAccessDeniedPage() {
        return ("access-denied");
    }
}

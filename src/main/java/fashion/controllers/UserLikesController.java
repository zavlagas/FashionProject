/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.controllers;

import fashion.entity.Product;
import fashion.entity.User;
import fashion.services.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class UserLikesController {
    
    
    @Autowired
    UserService service;
    
    
    @PutMapping("/likes/user")
    public ResponseEntity<?> updateLikesOfTheUser(@RequestBody User newUserDetails){
        User oldUserDetails = service.getAuthorizedUser(newUserDetails.getUsername());
        oldUserDetails.setLikedProducts(newUserDetails.getLikedProducts());
        boolean isUpdated = service.updateNewUserDetails(oldUserDetails);
        return (ResponseEntity.ok().body(isUpdated));
    }
    
}

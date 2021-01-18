/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.controllers;

import fashion.entity.User;
import fashion.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUserDetails(@RequestBody User newUser, @PathVariable("id") int id) {
        User oldUser = service.findUserById(id);
        oldUser.setFirstName(newUser.getFirstName());
        oldUser.setLastName(newUser.getLastName());
        oldUser.setDob(newUser.getDob());
        oldUser.setUsername(newUser.getUsername());
        oldUser.setPassword(newUser.getFirstName());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setImage(newUser.getImage());
        boolean isUpdated = service.updateNewUserDetails(oldUser);
        return (ResponseEntity.ok().body(isUpdated));
    }
    
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id){
            boolean isDeleted = service.deleteUserFromDb(id);
            return(ResponseEntity.ok().body(isDeleted));
    }

}

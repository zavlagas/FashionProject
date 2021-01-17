/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.controllers;

import fashion.entity.Product;
import fashion.entity.User;
import fashion.services.ProductService;
import fashion.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class UserProductLikesController {

    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    @GetMapping("/likes/user/{id}")
    public ResponseEntity<List<Product>> getLikesOfTheUser(@PathVariable("id") int id) {
        List<Product> likedProducts = productService.getUserLikedProducts(id);
        return (ResponseEntity.ok().body(likedProducts));
    }

    @GetMapping("/likes/user/{userId}/product/{productId}")
    public ResponseEntity<?> addLikesToTheProduct(
            @PathVariable("userId") int userId,
            @PathVariable("productId") int productId
    ) {
        User user = userService.findUserById(userId);
        Product product = productService.getProductByIdwithTheLikes(productId);
        product.getLikedProductUsers().add(user);
        boolean isUpdated = productService.updateProduct(product);
        return (ResponseEntity.ok().body(isUpdated));
    }
    
    
    @DeleteMapping("/likes/user/{userId}/product/{productId}")
    public ResponseEntity<?> deleteLikesFromTheProduct(
            @PathVariable("userId") int userId,
            @PathVariable("productId") int productId
    ) {
        User user = userService.findUserById(userId);
        Product product = productService.getProductByIdwithTheLikes(productId);
        product.getLikedProductUsers().remove(user);
        boolean isUpdated = productService.updateProduct(product);
        return (ResponseEntity.ok().body(isUpdated));
    }

}

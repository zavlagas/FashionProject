/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.controllers;

import fashion.entity.Product;
import fashion.services.ProductService;
import java.io.File;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    @Autowired
    private ProductService service;

    ///Get All Products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAllProducts() {
        return (ResponseEntity.ok().body(service.getAllProducts()));
    }

    //Get Single Product
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable("id") int id) {
        return (Optional
                .ofNullable(service.getProductById(id))
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build()));

    }
    
    
    @GetMapping("/products/user/{id}")
    public ResponseEntity<List<Product>> getAllProductsByUser(@PathVariable("id") int userId) {
        List<Product> allUserProducts = service.findUserProducts(userId);
        return (ResponseEntity.ok().body(allUserProducts));
    }

    //Put New Product 
    @PutMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody Product newProduct, MultipartFile file) {
        boolean isCreated = service.createProduct(newProduct);
        return (ResponseEntity.ok().body(isCreated));
    }

    //Post/Update Product
    @PostMapping("/products/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product updatedProduct, @PathVariable("id") int id) {
        Product oldProduct = service.getProductById(id);
        oldProduct.setDescr(updatedProduct.getDescr());
        oldProduct.setName(updatedProduct.getName());
        oldProduct.setProductImageList(updatedProduct.getProductImageList());
        boolean isUpdated = service.updateProduct(oldProduct);
        return (ResponseEntity.ok()
                .body(isUpdated));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") int id) {
        boolean isDeleted = service.deleteProduct(id);
        return (ResponseEntity.ok()
                .body(isDeleted));
    }

}

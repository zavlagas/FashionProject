/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.controllers;

import fashion.entity.Product;
import fashion.services.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
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

    //Put New Product 
    @PutMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody Product newProduct) {
        service.createProduct(newProduct);
        return (ResponseEntity.ok().body("New Product has Been Saved"));
    }

    //Post/Update Product
    @PostMapping("/products/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product updatedProduct, @PathVariable("id") int id) {
        Product oldProduct = service.getProductById(id);
        oldProduct.setBrand(updatedProduct.getBrand());
        oldProduct.setDescr(updatedProduct.getDescr());
        oldProduct.setName(updatedProduct.getName());
        oldProduct.setProductImageList(updatedProduct.getProductImageList());
        service.updateProduct(oldProduct);
        return (ResponseEntity.ok()
                .body("The Product With The Id : " + oldProduct.getId() + " Has Been Updated"));
    }
    
    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") int id){
        service.deleteProduct(id);
         return (ResponseEntity.ok()
                .body("The Product With The Id : " + id + " Has Been Deleted"));
    }

}

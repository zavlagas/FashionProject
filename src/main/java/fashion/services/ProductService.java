/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.services;

import fashion.entity.Product;
import java.util.List;


public interface ProductService {

    public List<Product> getAllProducts();

    public Product getProductById(int id);

    public boolean createProduct(Product newProduct);

    public boolean updateProduct(Product oldProduct);

    public void deleteProduct(int id);
    
}

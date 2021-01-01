/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.daos;

import fashion.entity.Product;
import java.util.List;

/**
 *
 * @author User
 */
public interface ProductDao {

    public List<Product> getAllProducts();

    public Product getProductById(int id);

    public void createProduct(Product newProduct);

    public void updateProduct(Product oldProduct);

    public void deleteProduct(int id);
    
}

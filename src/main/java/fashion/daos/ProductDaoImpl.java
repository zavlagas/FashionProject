/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.daos;

import fashion.entity.Product;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl extends SuperDao implements ProductDao {
    
    @Override
    public List<Product> getAllProducts() {
        return getSession().createNamedQuery("Product.findAll", Product.class).getResultList();
    }
    
    @Override
    public Product getProductById(int id) {
        return getSession().createNamedQuery("Product.findById", Product.class).setParameter("id", id).uniqueResult();
    }
    
    @Override
    public void createProduct(Product newProduct) {
        getSession().save(newProduct);
    }
    
    @Override
    public void updateProduct(Product oldProduct) {
        getSession().save(oldProduct);
    }
    
    @Override
    public void deleteProduct(int id) {
        Product product = getProductById(id);
        getSession().delete(product);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.services;

import fashion.daos.ProductDao;
import fashion.entity.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    private ProductDao dao;
    
    
    @Override
    public List<Product> getAllProducts() {
        return (dao.getAllProducts());
    }

    @Override
    public Product getProductById(int id) {
       return (dao.getProductById(id));
    }

    @Override
    public void createProduct(Product newProduct) {
        dao.createProduct(newProduct);
    }

    @Override
    public void updateProduct(Product oldProduct) {
       dao.updateProduct(oldProduct);
    }

    @Override
    public void deleteProduct(int id) {
        dao.deleteProduct(id);
    }
    
}
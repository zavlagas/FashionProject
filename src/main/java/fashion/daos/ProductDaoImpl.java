/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.daos;

import fashion.entity.Product;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;
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
    public boolean createProduct(Product newProduct) {
        boolean isCreated = false;
        try {
            getSession().save(newProduct);
            isCreated = true;
        } catch (ConstraintViolationException e) {
            System.out.println(e.fillInStackTrace());
        }
        return (isCreated);
    }

    @Override
    public boolean updateProduct(Product oldProduct) {
        boolean isUpdated = false;
        try {
            getSession().saveOrUpdate(oldProduct);
            isUpdated = true;
        } catch (ConstraintViolationException e) {
            System.out.println(e.fillInStackTrace());
        }
        return (isUpdated);
    }

    @Override
    public boolean deleteProduct(int id) {
        Product product = getProductById(id);
        boolean isDeleted = false;
        try {
            getSession().delete(product);
            isDeleted = true;
        } catch (ConstraintViolationException e) {
            System.out.println(e.fillInStackTrace());
        }
        return (isDeleted);
    }

}

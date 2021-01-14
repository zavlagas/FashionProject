package fashion.daos;

import fashion.entity.Brand;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;

@Repository
public class BrandDaoImpl extends SuperDao implements BrandDao {

    @Override
    public boolean create(Brand newBrand) {
        boolean isSaved = false;
        try {
            getSession().save(newBrand);
            isSaved = true;

        } catch (ConstraintViolationException e) {
            System.out.println(e.fillInStackTrace());
        }
        return (isSaved);
    }

    @Override
    public Brand findBrandBy(Integer brandId) {
        return (getSession().createNamedQuery("Brand.findById", Brand.class).setParameter("id", brandId).uniqueResult());

    }

    @Override
    public boolean update(Brand oldBrand) {
        boolean isUpdated = false;
        try {
            getSession().save(oldBrand);
            isUpdated = true;

        } catch (ConstraintViolationException e) {
            System.out.println(e.fillInStackTrace());
        }
        return (isUpdated);
    }

    @Override
    public boolean deleteBrandBy(int brandId) {
        Brand brand = findBrandBy(brandId);
        boolean isDeleted = false;
        try {
            getSession().delete(brand);
            isDeleted = true;

        } catch (ConstraintViolationException e) {
            System.out.println(e.fillInStackTrace());

        }
        return (isDeleted);

    }

    @Override
    public List<Brand> findAll() {
        return getSession().createNamedQuery("Brand.findAll", Brand.class).getResultList();
    }

    @Override
    public List<Brand> findAllUserBrands(int userId) {
        return getSession().createNamedQuery("Brand.findBrandsByUserId", Brand.class)
                .setParameter("id", userId).getResultList();
    }

}

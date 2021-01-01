package fashion.daos;

import fashion.entity.Brand;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class BrandDaoImpl extends SuperDao implements BrandDao {

    @Override
    public void create(Brand newBrand) {
        getSession().save(newBrand);
    }

    @Override
    public Brand findBrandBy(Integer brandId) {
        return (getSession().createNamedQuery("Brand.findById", Brand.class).setParameter("id", brandId).uniqueResult());

    }

    @Override
    public void update(Brand oldBrand) {
        getSession().save(oldBrand);
    }

    @Override
    public void deleteBrandBy(int brandId) {
        Brand brand = findBrandBy(brandId);
        getSession().delete(brand);
    }

    @Override
    public List<Brand> findAll() {
        return getSession().createNamedQuery("Brand.findAll", Brand.class).getResultList();
    }

}

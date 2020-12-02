package fashion.daos;

import fashion.entity.Brand;


public class BrandDaoImpl extends SuperDao implements BrandDao {

    @Override
    public void create(Brand newBrand) {
        getSession().save(newBrand);
    }

    @Override
    public Brand findBrandBy(Integer brandId) {
        return(getSession().createNamedQuery("Brand.findById", Brand.class).setParameter("id", brandId).getSingleResult());
    }

    @Override
    public void update(Brand oldBrand) {
        getSession().save(oldBrand);
    }

    @Override
    public void deleteBrandBy(int brandId) {
        Brand deletedBrand = findBrandBy(brandId);
        getSession().delete(deletedBrand);
    }
    
}

package fashion.daos;

import fashion.entity.Brand;


public interface BrandDao {

    public void create(Brand newBrand);

    public Brand findBrandBy(Integer brandId);

    public void update(Brand oldBrand);
    
}

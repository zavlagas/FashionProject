package fashion.services;

import fashion.entity.Brand;
import java.util.List;


public interface BrandService {
    
    //List<Brand> getAllBrands();
    
    public void create(Brand newBrand);

    public Brand findByIdThe(Integer brandId);

    public void update(Brand oldBrand);

    public void deleteBrandBy(int brandId);

    public List<Brand> findAll();
    
    
    
}

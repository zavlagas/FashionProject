package fashion.services;

import fashion.entity.Brand;
import java.util.List;


public interface BrandService {
    
    //List<Brand> getAllBrands();
    
    public boolean create(Brand newBrand);

    public Brand findByIdThe(Integer brandId);

    public boolean update(Brand oldBrand);

    public void deleteBrandBy(int brandId);

    public List<Brand> findAll();

    public List<Brand> findUserBrands(int userId);
    
    
    
}

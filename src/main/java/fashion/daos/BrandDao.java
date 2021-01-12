package fashion.daos;

import fashion.entity.Brand;
import fashion.entity.User;
import java.util.List;


public interface BrandDao {

    public void create(Brand newBrand);

    public Brand findBrandBy(Integer brandId);

    public void update(Brand oldBrand);

    public void deleteBrandBy(int brandId);

    public List<Brand> findAll();

    public List<Brand> findAllUserBrands(int userId);
    
}

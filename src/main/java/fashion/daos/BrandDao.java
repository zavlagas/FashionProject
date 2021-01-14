package fashion.daos;

import fashion.entity.Brand;
import fashion.entity.User;
import java.util.List;


public interface BrandDao {

    public boolean create(Brand newBrand);

    public Brand findBrandBy(Integer brandId);

    public boolean update(Brand oldBrand);

    public boolean deleteBrandBy(int brandId);

    public List<Brand> findAll();

    public List<Brand> findAllUserBrands(int userId);
    
}

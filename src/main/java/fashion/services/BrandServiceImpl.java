package fashion.services;

import fashion.daos.BrandDao;
import fashion.daos.UserDao;
import fashion.entity.Brand;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao dao;

    @Override
    public boolean create(Brand newBrand) {
        return (dao.create(newBrand));
    }

    @Override
    public Brand findByIdThe(Integer brandId) {
        return (dao.findBrandBy(brandId));
    }

    @Override
    public boolean update(Brand oldBrand) {
        return (dao.update(oldBrand));
    }

    @Override
    public boolean deleteBrandBy(int brandId) {
        return (dao.deleteBrandBy(brandId));
    }

    @Override
    public List<Brand> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Brand> findUserBrands(int userId) {
        return dao.findAllUserBrands(userId);
    }

}

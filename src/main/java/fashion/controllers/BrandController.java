package fashion.controllers;

import fashion.entity.Brand;
import fashion.services.BrandService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class BrandController {

    @Autowired
    private BrandService service;

    @GetMapping("/brands")
    public ResponseEntity<List<Brand>> getAllBrands() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/brands/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable("id") int brandId) {

        return (Optional
                .ofNullable(service.findByIdThe(brandId))
                .map(brand -> ResponseEntity.ok().body(brand))
                .orElseGet(() -> ResponseEntity.notFound().build()));

    }

    @GetMapping("/brands/user/{id}")
    public ResponseEntity<List<Brand>> getAllBrandsByUser(@PathVariable("id") int userId) {
        List<Brand> allUserBrands = service.findUserBrands(userId);
        return (ResponseEntity.ok().body(allUserBrands));
    }

    @PostMapping("/brands")
    public ResponseEntity<?> createBrand(@RequestBody Brand newBrand) {
        boolean isSaved = service.create(newBrand);
        return ResponseEntity.ok().body(isSaved);
    }

    @PutMapping("/brands/{id}")
    public ResponseEntity<?> updateBrand(@RequestBody Brand newBrand, @PathVariable("id") int id) {
        Brand oldBrand = service.findByIdThe(id);
        oldBrand.setName(newBrand.getName());
        oldBrand.setProductList(newBrand.getProductList());
        oldBrand.setDescr(newBrand.getDescr());
        oldBrand.setImagePath(newBrand.getImagePath());
        oldBrand.setUser(newBrand.getUser());
        boolean isUpdated = service.update(oldBrand);
        return (ResponseEntity.ok().body(isUpdated));
    }

    @DeleteMapping("/brands/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable("id") int brandId) {
        boolean isBrandDeleted  = service.deleteBrandBy(brandId);
        return (ResponseEntity.ok().body(isBrandDeleted));
    }
}

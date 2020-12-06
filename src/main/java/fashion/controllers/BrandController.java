package fashion.controllers;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;
import fashion.entity.Brand;
import fashion.entity.UserSubscription;
import fashion.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BrandController {

    @Autowired
    private BrandService service;

    @GetMapping("/create")
    public String getBrandPageForm(Model model) {
        model.addAttribute("brand", new Brand());
        return ("/brand/create");
    }

    @PostMapping("/create")
    public String createBrand(@ModelAttribute("brand") Brand newBrand, RedirectAttributes ra) {
        service.create(newBrand);
        return (null);
    }

    @GetMapping("/update")
    public String getUpdatePageFormForProductsToBrand() {
        return ("/brand/update");
    }

    @PostMapping("/update")
    public String updateBrandWithNewProducts(@ModelAttribute("brand") Brand newBrand) {
        Brand oldBrand = service.findByIdThe(newBrand.getId());
        oldBrand.setName(newBrand.getName());
        oldBrand.setProductList(newBrand.getProductList());
        oldBrand.setDescr(newBrand.getDescr());
        oldBrand.setImagePath(newBrand.getImagePath());
        oldBrand.setUser(newBrand.getUser());
        service.update(oldBrand);
        return (null);
    }

    @GetMapping("/detele")
    public String DeleteBrand(@RequestParam("id") int brandId) {
        service.deleteBrandBy(brandId);
        return (null);
    }
}

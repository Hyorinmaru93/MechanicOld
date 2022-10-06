package pl.hyorinmaru.app.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.hyorinmaru.app.domain.*;
import pl.hyorinmaru.app.service.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user/car")
public class CarController {

    private CarService carService;

    private final CarBrandService carBrandService;

    private final CarModelService carModelService;

    private final CarCategoryService carCategoryService;

    private final UserService userService;

    public CarController(CarService carService,
                         CarBrandService carBrandService,
                         CarModelService carModelService,
                         CarCategoryService carCategoryService,
                         UserService userService) {
        this.carService = carService;
        this.carBrandService = carBrandService;
        this.carModelService = carModelService;
        this.carCategoryService = carCategoryService;
        this.userService = userService;
    }

    @GetMapping("/test")
    public String carTest(Model model){
        CarBrand BMW = carBrandService.carBrandById(1L);
        List<CarBrand> list = carBrandService.findAll();
        model.addAttribute("brand", BMW);
        model.addAttribute("list", list);
        return "carTest";
    }


    @GetMapping("/add")
    public String carForm(Model model,
                          @RequestParam(defaultValue = "") String carBrand,
                          @RequestParam(defaultValue = "") String carModel){
        model.addAttribute("car", new Car());
        model.addAttribute("brands",
                carBrandService.findAll().stream().map(CarBrand::getBrand).toList());
        model.addAttribute("models",
                carModelService.findAll().stream().map(CarModel::getModel).toList());
        model.addAttribute("categories",
                carCategoryService.findAll().stream().map(CarCategory::getCategory).toList());
        return "/user/carForm";
    }

    @PostMapping("/add")
    public String carAdd(@ModelAttribute("car") Car car){
//        car.setId(null);
        carService.create(car);
        return "redirect:/user/main";
    }
}

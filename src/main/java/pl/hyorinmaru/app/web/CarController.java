package pl.hyorinmaru.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.hyorinmaru.app.domain.Car;
import pl.hyorinmaru.app.domain.CarCategory;
import pl.hyorinmaru.app.service.CarBrandService;
import pl.hyorinmaru.app.service.CarService;

@Controller
@RequestMapping("/user/car")
public class CarController {

    private CarService carService;

    private CarBrandService carBrandService;

    public CarController(CarService carService, CarBrandService carBrandService) {
        this.carService = carService;
        this.carBrandService = carBrandService;
    }

    @GetMapping("/add")
    public String carForm(Model model){
//        model.addAttribute("brands", carBrandService.readBrands());
        model.addAttribute("car", new Car());
        return "/user/carForm";
    }
}

package pl.hyorinmaru.app.service;

import org.springframework.stereotype.Service;
import pl.hyorinmaru.app.domain.CarCategory;
import pl.hyorinmaru.app.repository.CarCategoryRepository;

import java.util.List;

@Service
public class CarCategoryService {

    private final CarCategoryRepository carCategoryRepository;

    public CarCategoryService(CarCategoryRepository carCategoryRepository) {
        this.carCategoryRepository = carCategoryRepository;
    }

    public List<CarCategory> findAll(){
        return carCategoryRepository.findAll();
    }
}

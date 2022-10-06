package pl.hyorinmaru.app.service;

import org.springframework.stereotype.Service;
import pl.hyorinmaru.app.domain.CarBrand;
import pl.hyorinmaru.app.repository.CarBrandRepository;

import java.util.List;

@Service
public class CarBrandService {

    private final CarBrandRepository carBrandRepository;

    public CarBrandService(CarBrandRepository carBrandRepository) {
        this.carBrandRepository = carBrandRepository;
    }

    public CarBrand carBrandById (Long id){
        return carBrandRepository.findCarBrandById(id);
    }

    public List<CarBrand> findAll(){
        return carBrandRepository.findAll();
    }

}

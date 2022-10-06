package pl.hyorinmaru.app.service;

import org.springframework.stereotype.Service;
import pl.hyorinmaru.app.domain.CarModel;
import pl.hyorinmaru.app.repository.CarModelRepository;

import java.util.List;

@Service
public class CarModelService {

    private final CarModelRepository carModelRepository;

    public CarModelService(CarModelRepository carModelRepository) {
        this.carModelRepository = carModelRepository;
    }

    public List<CarModel> findAll(){
        return carModelRepository.findAll();
    }

    public List<CarModel> findByBrandId(Long id){
        return carModelRepository.findCarModelsByBrandId(id);
    }
}

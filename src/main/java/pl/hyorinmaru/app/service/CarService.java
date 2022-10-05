package pl.hyorinmaru.app.service;

import org.springframework.stereotype.Service;
import pl.hyorinmaru.app.domain.Car;
import pl.hyorinmaru.app.domain.User;
import pl.hyorinmaru.app.repository.CarRepository;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void create(Car car) {
        carRepository.save(car);
    }

    public Car readById(Long id) {
        return carRepository.readCarById(id);
    }

    public List<Car> readCarByOwner(User user) {
        return carRepository.findCarByUser(user);
    }

    public List<Car> readAll() {
        return carRepository.findAll();
    }

    public void update(Car car) {
        carRepository.update(car.getBrand(), car.getModel(), car.getCategory(), car.getProductionDate(), car.getCustomName());
    }

    public void delete(Car car) {
        carRepository.delete(car);
    }
}

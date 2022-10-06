package pl.hyorinmaru.app.service;

import org.springframework.stereotype.Service;
import pl.hyorinmaru.app.domain.ExampleServiceOrder;
import pl.hyorinmaru.app.repository.ExampleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExampleService {

    private final ExampleRepository exampleRepository;

    public ExampleService(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    public void create(ExampleServiceOrder exampleServiceOrder) {
        exampleRepository.save(exampleServiceOrder);
    }

    public void update(ExampleServiceOrder exampleServiceOrder) {
        exampleRepository.update(exampleServiceOrder.getCategory(),
                exampleServiceOrder.getEstimatedTime(),
                exampleServiceOrder.getPrice(),
                exampleServiceOrder.getSimpleService(),
                exampleServiceOrder.getId());
    }

    public Optional<ExampleServiceOrder> readById(Long id) {
        return exampleRepository.findById(id);
    }

    public List<ExampleServiceOrder> exampleList() {
        return exampleRepository.findAll();
    }

    public List<ExampleServiceOrder> exampleListByCategory(String category) {
        return exampleRepository.findAllByCategory(category);
    }
}

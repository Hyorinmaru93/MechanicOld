package pl.hyorinmaru.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.hyorinmaru.app.domain.CarModel;

import java.util.List;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {

    List<CarModel> findCarModelsByBrandId(Long id);
}

package pl.hyorinmaru.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.hyorinmaru.app.domain.CarBrand;

import java.util.List;

@Repository
public interface CarBrandRepository extends JpaRepository <CarBrand, Long> {

    CarBrand findCarBrandById(Long id);
}

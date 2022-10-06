package pl.hyorinmaru.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.hyorinmaru.app.domain.CarCategory;

@Repository
public interface CarCategoryRepository extends JpaRepository<CarCategory, Long> {
}

package pl.hyorinmaru.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.hyorinmaru.app.domain.Car;
import pl.hyorinmaru.app.domain.User;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface CarRepository extends JpaRepository<Car, Long> {

    Car readCarById(Long id);

    List<Car> findCarByUser(User user);

    @Modifying
    @Transactional
    @Query("update Car c set c.brand = ?1, c.model = ?2, c.category =?3, c.productionDate = ?4, c.customName = ?5")
    void update(String brand, String model, String category, int productionDate, String customName);


}

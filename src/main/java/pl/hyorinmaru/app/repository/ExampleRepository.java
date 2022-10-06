package pl.hyorinmaru.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.hyorinmaru.app.domain.ExampleServiceOrder;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface ExampleRepository extends JpaRepository<ExampleServiceOrder, Long> {

    public List<ExampleServiceOrder> findAllByCategory(String category);

    @Transactional
    @Modifying
    @Query("update ExampleServiceOrder ex " +
            "set ex.category=?1, ex.estimatedTime=?2, ex.price=?3, ex.simpleService = ?4" +
            "where ex.id=?5")
    void update(String category, String estimatedTime, Double price, String serviceName, Long id);
}

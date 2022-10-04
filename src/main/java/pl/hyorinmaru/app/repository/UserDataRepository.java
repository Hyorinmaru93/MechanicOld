package pl.hyorinmaru.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.hyorinmaru.app.domain.UserData;

public interface UserDataRepository extends JpaRepository <UserData, Long> {
    UserData readById(Long id);
    UserData readUserDataByEmail(String email);
    @Modifying
    @Transactional
    @Query("update UserData u set u = ?1 where u.id=?2")
    void update(UserData userData, Long id);

    @Modifying
    @Transactional
    void deleteUserDataById(Long id);
}

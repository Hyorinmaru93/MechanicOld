package pl.hyorinmaru.app.service;

import org.springframework.stereotype.Service;
import pl.hyorinmaru.app.domain.UserData;
import pl.hyorinmaru.app.repository.UserDataRepository;

@Service
public class UserDataService {

    private final UserDataRepository userDataRepository;

    public UserDataService(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    public void save(UserData userData) {
        userDataRepository.save(userData);
    }

    public UserData findByUserId(Long id) {
        return userDataRepository.readById(id);
    }

    public UserData findByUserEmail(String email) {
        return userDataRepository.readUserDataByEmail(email);
    }

    public void updateUserData(UserData userData) { userDataRepository.update(userData, userData.getId());}

    public void deleteUserDataById(Long id) {userDataRepository.deleteUserDataById(id);}

    public void deleteUserData(UserData userData) {userDataRepository.delete(userData);}

}

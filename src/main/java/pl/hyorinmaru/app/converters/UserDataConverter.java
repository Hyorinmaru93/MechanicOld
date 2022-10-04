package pl.hyorinmaru.app.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.hyorinmaru.app.domain.UserData;
import pl.hyorinmaru.app.service.UserDataService;

public class UserDataConverter implements Converter<String, UserData> {

    private UserDataService userDataService;

    @Autowired
    public void setUserDataService(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @Override
    public UserData convert(String id) {
        return userDataService.findByUserId(Long.parseLong(id));
    }

}

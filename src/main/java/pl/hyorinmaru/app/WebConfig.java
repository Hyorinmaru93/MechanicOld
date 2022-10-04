package pl.hyorinmaru.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.hyorinmaru.app.converters.UserDataConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(userDataConverter());
    }
    @Bean
    public UserDataConverter userDataConverter() {return new UserDataConverter();}

}

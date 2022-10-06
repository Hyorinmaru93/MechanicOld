package pl.hyorinmaru.app.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.hyorinmaru.app.domain.CarBrand;

@Component
public class BrandConverter implements Converter<Long, CarBrand> {



    @Override
    public CarBrand convert(Long source) {
        return null;
    }
}

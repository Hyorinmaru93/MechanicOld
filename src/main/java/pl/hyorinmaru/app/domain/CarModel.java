package pl.hyorinmaru.app.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "model_categories", joinColumns = @JoinColumn(name = "model_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<CarCategory> carCategories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Set<CarCategory> getCarCategories() {
        return carCategories;
    }

    public void setCarCategories(Set<CarCategory> carCategories) {
        this.carCategories = carCategories;
    }
}

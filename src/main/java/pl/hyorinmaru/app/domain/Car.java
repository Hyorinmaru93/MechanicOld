package pl.hyorinmaru.app.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //maker
    private String brand;

    //model
    private String model;

    //category fe. sedan, suv
    private String category;

    //Year
    private int productionDate;

    private String customName;

    @ManyToOne
    private User user;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "car")
//    private List<Assignement> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(int productionDate) {
        this.productionDate = productionDate;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", category='" + category + '\'' +
                ", productionDate=" + productionDate +
                ", customName='" + customName + '\'' +
                ", user=" + user.getUsername() +
                '}';
    }

//    public List<Assignement> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Assignement> orders) {
//        this.orders = orders;
//    }
}

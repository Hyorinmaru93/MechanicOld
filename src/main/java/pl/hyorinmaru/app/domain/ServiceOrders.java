package pl.hyorinmaru.app.domain;

import javax.persistence.*;

@Entity
public class ServiceOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    private String simpleService;

    private Double price;

    private String estimatedTime;

    private Boolean done;

    @ManyToOne
    private Assignement order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSimpleService() {
        return simpleService;
    }

    public void setSimpleService(String simpleService) {
        this.simpleService = simpleService;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Assignement getOrder() {
        return order;
    }

    public void setOrder(Assignement order) {
        this.order = order;
    }
}

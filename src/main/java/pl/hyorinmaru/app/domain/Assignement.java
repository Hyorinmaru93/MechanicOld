package pl.hyorinmaru.app.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Assignement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
//    private List<ServiceOrders> toDos;

    @ManyToOne
    private User user;
    @ManyToOne
    private Car car;
    private LocalDateTime createdOn;
    private LocalDateTime closedOn;
    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public List<ServiceOrders> getToDo() {
//        return toDos;
//    }
//
//    public void setToDo(List<ServiceOrders> toDos) {
//        this.toDos = toDos;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getClosedOn() {
        return closedOn;
    }

    public void setClosedOn(LocalDateTime closedOn) {
        this.closedOn = closedOn;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

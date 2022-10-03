package pl.hyorinmaru.app.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //maker
    private String brand;

    //model
    private String model;

    //category fe. sedan, suv
    private String category;

    //Year
    private LocalDate productionDate;

    @ManyToOne
    private User owner;

}

package ru.javatrainee.study.advanced.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Table(name = "persons")
@Entity
@NoArgsConstructor
@ToString(exclude = "cars")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String name;

    private int number;

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Car> cars = new HashSet<>();

    public Person(String name, int number) {
        this.name = name;
        this.number = number;
    }
}

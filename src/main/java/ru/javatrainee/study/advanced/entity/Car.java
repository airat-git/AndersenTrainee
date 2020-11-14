package ru.javatrainee.study.advanced.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "cars")
@ToString(exclude = {"id","person","personId"})
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "person_id",insertable = false,updatable = false)
    private long personId;

    public Car(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}

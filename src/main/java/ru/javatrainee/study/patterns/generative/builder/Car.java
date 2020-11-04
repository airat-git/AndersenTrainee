package ru.javatrainee.study.patterns.generative.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private String name;
    private int maxSpeed;
    private Transmission transmission;

    public void getCharacters(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", transmission=" + transmission +
                '}';
    }
}

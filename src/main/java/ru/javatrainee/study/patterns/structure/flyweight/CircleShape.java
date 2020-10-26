package ru.javatrainee.study.patterns.structure.flyweight;

public class CircleShape implements Shape {

    private int radius = 5;

    @Override
    public void draw(int x, int y) {
        System.out.println("Кргуг с координатами " + x + " " + y + ", и радиусом " + radius );
    }
}

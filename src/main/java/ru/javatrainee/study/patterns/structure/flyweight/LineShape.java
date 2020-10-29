package ru.javatrainee.study.patterns.structure.flyweight;

public class LineShape implements Shape {

    @Override
    public void draw(int x, int y) {
        System.out.println("Линия с координатами " + x + " " + y);
    }
}

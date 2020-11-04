package ru.javatrainee.study.patterns.structure.flyweight;

public class SquareShape implements Shape{

    private int a = 10;

    @Override
    public void draw(int x, int y) {
        System.out.println("Квадрат с координатами " + x + " " + y + ", и сторонами " + a );
    }
}

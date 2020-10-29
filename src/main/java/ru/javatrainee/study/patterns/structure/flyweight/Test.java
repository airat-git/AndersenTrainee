package ru.javatrainee.study.patterns.structure.flyweight;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();
        ArrayList<Shape> arrayList = new ArrayList<>();
        arrayList.add(shapeFactory.getShape("line"));
        arrayList.add(shapeFactory.getShape("square"));
        arrayList.add(shapeFactory.getShape("line"));
        arrayList.add(shapeFactory.getShape("circle"));

        int count = 0;
        for (Shape shape: arrayList){
            shape.draw(count+1,count+2);
            count++;
        }
    }
}

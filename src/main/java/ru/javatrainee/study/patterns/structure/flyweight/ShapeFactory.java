package ru.javatrainee.study.patterns.structure.flyweight;

import java.util.HashMap;

public class ShapeFactory {

    private static final HashMap<String,Shape> shapes = new HashMap();

    public Shape getShape(String shapeName){
        Shape shape = shapes.get(shapeName);
        if (shape == null){
            if (shapeName.equals("line")){
                shape = new LineShape();
            }
            if (shapeName.equals("circle")){
                shape = new CircleShape();
            }
            if (shapeName.equals("square")){
                shape = new SquareShape();
            }
            shapes.put(shapeName,shape);
        }
        return shape;
    }
}

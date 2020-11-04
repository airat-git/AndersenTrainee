package ru.javatrainee.study.patterns.structure.adapter;

public class Test {
    public static void main(String[] args) {

        VectorGraphicInterface vectorGraphicInterface = new VectorGraphicAdapter();
        vectorGraphicInterface.drawLine();
        vectorGraphicInterface.drawSquare();
    }
}

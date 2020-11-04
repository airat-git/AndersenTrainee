package ru.javatrainee.study.patterns.structure.adapter;

public class VectorGraphicAdapter extends OldGraphicInterface implements VectorGraphicInterface {

    @Override
    public void drawLine() {
        drawingLine();
    }

    @Override
    public void drawSquare() {
        drawingSquare();
    }
}

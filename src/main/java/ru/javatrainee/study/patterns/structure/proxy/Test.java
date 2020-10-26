package ru.javatrainee.study.patterns.structure.proxy;

public class Test {

    public static void main(String[] args) {
        Image image = new ImageProxy("file");
        image.show();
    }
}

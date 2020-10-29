package ru.javatrainee.study.patterns.structure.decorator;

public class Test {

    public static void main(String[] args) {

        Printer printer = new DecoratorOne(new DecoratorTwo(new PrinterImpl("hey")));
        printer.print();
    }
}

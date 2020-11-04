package ru.javatrainee.study.patterns.structure.decorator;

public class DecoratorTwo extends Decorator {

    public DecoratorTwo(Printer printer) {
        super(printer);
    }

    @Override
    public void print() {
        System.out.println("Decorator number two");
        super.printer.print();
    }
}

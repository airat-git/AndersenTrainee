package ru.javatrainee.study.patterns.structure.decorator;

public class DecoratorOne extends Decorator {

    public DecoratorOne(Printer printer) {
        super(printer);
    }

    @Override
    public void print() {
        System.out.println("Decorator number one");
        super.printer.print();
    }
}

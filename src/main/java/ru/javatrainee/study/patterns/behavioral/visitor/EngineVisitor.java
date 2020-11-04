package ru.javatrainee.study.patterns.behavioral.visitor;

public class EngineVisitor implements Visitor{

    @Override
    public void visit(EngineElement engineElement) {
        System.out.println("Завел двигатель");
    }

    @Override
    public void visit(BodyElement bodyElement) {
        System.out.println("Починил капот");
    }
}

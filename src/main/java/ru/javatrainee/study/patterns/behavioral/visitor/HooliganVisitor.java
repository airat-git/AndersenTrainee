package ru.javatrainee.study.patterns.behavioral.visitor;

public class HooliganVisitor implements Visitor {

    @Override
    public void visit(EngineElement engineElement) {
        System.out.println("Поломал двигатель");
    }

    @Override
    public void visit(BodyElement bodyElement) {
        System.out.println("Пнул по капоту");
    }
}
